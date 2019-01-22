package com.leek.wars.client;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leek.wars.client.cmd.CommandLineAppProcessor;
import com.leek.wars.client.graphic.ClientFrameFX;
import com.leek.wars.client.util.GlobalProperties;
import com.leek.wars.client.util.UseMode;
import com.leek.wars.client.util.accounts.AccountHelper;
import com.leek.wars.client.util.exceptions.LWException;
import com.leek.wars.client.util.exceptions.MissingParameterException;
import com.leek.wars.client.util.exceptions.NotADirectoryException;
import com.leek.wars.client.util.exceptions.NotAFileException;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.exceptions.WrongUseModeException;
import com.leek.wars.client.util.parameters.Parameter;

import javafx.application.Application;

public class AppCli {

	private static Logger logger;

	private static final Parameter PATH_LOGS = new Parameter("logs.path", false);
	private static final Parameter PATH_PARAM = new Parameter("conf.path", true);
	private static final Parameter PATH_IMAGES = new Parameter("images.path", true);
	private static final Parameter PATH_DATA = new Parameter("data.path", true);
	private static final Parameter USE_MODE = new Parameter("mode", false);

	public static void main(String[] args) throws ServerException, IOException, LWException {

		initParams(PATH_PARAM, PATH_IMAGES, PATH_LOGS, PATH_DATA, USE_MODE);

		verifyFiles(PATH_PARAM);
		verifyDirectories(PATH_LOGS, PATH_IMAGES, PATH_DATA);

		UseMode useMode = defineUseMode(USE_MODE);

		initLogger();
		
		AccountHelper.INSTANCE.init(PATH_DATA.getValue());
		GlobalProperties.INSTANCE.init(PATH_PARAM.getValue());

		logger.debug("Initialization OK");

		switch (useMode) {
		case COMMAND_LINE:
			CommandLineAppProcessor.INSTANCE.start();
			break;
		case GRAPHIC_INTERFACE:
			Application.launch(ClientFrameFX.class, args);
			break;
		default:
			System.out.println("Use mode not implemented yet ...");
			break;
		}
	}

	private static UseMode defineUseMode(Parameter useModeParam) throws WrongUseModeException {
		UseMode useMode = UseMode.DEFAULT_USE_MODE;

		String useModeStr = useModeParam.getValue();
		if (useModeStr != null) {
			useMode = UseMode.valueOf(useModeStr);
			if (useMode == null) {
				throw new WrongUseModeException(useModeStr);
			}
		}

		return useMode;
	}

	private static void verifyDirectories(Parameter... params) throws NotADirectoryException {
		for (Parameter param : params) {

			if (param.getValue() == null) {
				continue;
			}

			File f = new File(param.getValue());
			if (!f.exists() || !f.isDirectory()) {
				throw new NotADirectoryException(param.getKey(), param.getValue());
			}
		}
	}

	private static <V> void verifyFiles(Parameter... params) throws NotAFileException {
		for (Parameter param : params) {

			if (param.getValue() == null) {
				continue;
			}

			File f = new File(param.getValue());
			if (!f.exists() || !f.isFile()) {
				throw new NotAFileException(param.getKey(), param.getValue());
			}
		}
	}

	private static void initLogger() {
		if (PATH_LOGS.getValue() != null) {
			LocalDateTime ldt = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
			System.setProperty("log.name", PATH_LOGS.getValue() + "/" + ldt.format(dtf) + ".txt");
		}
		logger = LoggerFactory.getLogger(AppCli.class);
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
