package com.leek.wars.client;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leek.wars.client.graphic.ClientFrameFX;
import com.leek.wars.client.util.GlobalProperties;
import com.leek.wars.client.util.exceptions.MissingParameterException;
import com.leek.wars.client.util.exceptions.NotAFileException;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.parameters.Parameter;

import javafx.application.Application;

public class AppCli {

	private static final Logger logger = LoggerFactory.getLogger(AppCli.class);


	private static final Parameter PATH_LOGS = new Parameter("logs.path", false);
	private static final Parameter PATH_PARAM = new Parameter("conf.path", true);
	private static final Parameter PATH_IMAGES = new Parameter("images.path", true);

	public static void main(String[] args) throws ServerException, IOException {

		try {
			initParams(PATH_PARAM, PATH_IMAGES, PATH_LOGS);
		} catch (MissingParameterException e) {
			logger.error("Missing parameters", e);
			return;
		}

		try {
			verifyFiles(PATH_LOGS, PATH_PARAM, PATH_IMAGES);
		} catch (NotAFileException e) {
			logger.error("Problem accessing a parameter file", e);
			return;
		}

		if (PATH_LOGS.getValue() != null) {
			initLogger();
		}

		try {
			GlobalProperties.INSTANCE.init(PATH_PARAM.getValue());
		} catch (IOException e) {
			logger.error("Can't init global properties", e);
			return;
		}

		Application.launch(ClientFrameFX.class, args);
	}

	private static void verifyFiles(Parameter... params) throws NotAFileException {
		for (Parameter param : params) {

			if (param.getValue() == null) {
				continue;
			}

			File f = new File(param.getValue());
			if (!f.exists()) {
				throw new NotAFileException(param.getKey(), param.getValue());
			}
		}
	}

	private static void initLogger() {
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
		System.setProperty("log.name", PATH_LOGS.getValue() + "/" + ldt.format(dtf) + ".txt");
	}

	private static void initParams(Parameter... parameters) throws MissingParameterException {
		List<String> missingParameters = new ArrayList<>();
		for (Parameter p : parameters) {
			String value = System.getProperty(p.getKey());
			if (p.isRequired() && value == null) {
				missingParameters.add(p.getKey());
				continue;
			}
			p.setValue(value);
		}
		if (!missingParameters.isEmpty()) {
			throw new MissingParameterException(missingParameters);
		}
	}

}
