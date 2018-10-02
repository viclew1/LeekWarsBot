package com.leek.wars.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leek.wars.client.entities.responses.SessionResponse;
import com.leek.wars.client.util.GlobalProperties;
import com.leek.wars.client.util.exceptions.MissingParameterException;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.nav.menus.AbstractMenu;
import com.leek.wars.client.util.nav.menus.impl.HomeMenu;
import com.leek.wars.client.util.parameters.Parameter;
import com.leek.wars.client.util.rest.RequestProcessor;

public class AppCli {

	private static final Logger logger = LoggerFactory.getLogger(AppCli.class);


	private static final Parameter PATH_PARAM = new Parameter("global.infos.path", true);

	public static void main(String[] args) throws ServerException, IOException {
		try {
			initParams(PATH_PARAM);
		} catch (MissingParameterException e) {
			logger.error("Missing parameters", e);
			return;
		}

		logger.info("Params OK");

		try {
			GlobalProperties.INSTANCE.init(PATH_PARAM.getValue());
		} catch (IOException e) {
			logger.error("Can't init global properties", e);
			return;
		}

		SessionResponse session = RequestProcessor.INSTANCE.getSession();
		
		AbstractMenu nextMenu = new HomeMenu(null, session);
		AbstractMenu currentMenu = null;
		
		while (nextMenu != null) {
			AbstractMenu newNextMenu = nextMenu.run(currentMenu);
			currentMenu = nextMenu;
			nextMenu = newNextMenu;
		}
	}

	public static void initParams(Parameter... parameters) throws MissingParameterException {
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
