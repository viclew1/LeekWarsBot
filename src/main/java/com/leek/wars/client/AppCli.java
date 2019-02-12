package com.leek.wars.client;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leek.wars.client.nav.menus.HomeMenu;
import com.leek.wars.client.util.GlobalProperties;
import com.leek.wars.client.util.accounts.AccountHelper;
import com.leek.wars.client.util.ais.AisHelper;

import fr.lewon.client.AbstractAppClient;
import fr.lewon.client.exceptions.CliException;
import fr.lewon.client.exceptions.InitializationException;
import fr.lewon.client.menus.Menu;
import fr.lewon.client.util.parameters.Parameter;
import fr.lewon.client.util.parameters.impl.DirParameter;
import fr.lewon.client.util.parameters.impl.FileParameter;

public class AppCli extends AbstractAppClient {

	private static Logger logger;

	private static final Parameter PATH_LOGS_PARAM = new DirParameter("logs.path", false, true);
	private static final Parameter PATH_CONF_PARAM = new FileParameter("conf.path", true, true);
	private static final Parameter PATH_DATA_PARAM = new DirParameter("data.path", true, true);

	private static void initLogger() {
		if (PATH_LOGS_PARAM.getValue() != null) {
			LocalDateTime ldt = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
			System.setProperty("log.name", PATH_LOGS_PARAM.getValue() + "/" + ldt.format(dtf) + ".txt");
		}
		logger = LoggerFactory.getLogger(AppCli.class);
	}

	@Override
	protected List<Parameter> getParamsToInit() {
		List<Parameter> parametersToInit = new ArrayList<>();
		parametersToInit.add(PATH_LOGS_PARAM);
		parametersToInit.add(PATH_CONF_PARAM);
		parametersToInit.add(PATH_DATA_PARAM);
		return parametersToInit;
	}

	@Override
	protected void initUtils() throws InitializationException {
		initLogger();
		try {
			AccountHelper.INSTANCE.init(PATH_DATA_PARAM.getValue());
			AisHelper.INSTANCE.init(PATH_DATA_PARAM.getValue());
			GlobalProperties.INSTANCE.init(PATH_CONF_PARAM.getValue());
			logger.info("Initialization OK");
		} catch (IOException e) {
			throw new InitializationException(e);
		}
	}

	@Override
	protected Menu getHomeMenu() {
		return new HomeMenu();
	}

	public static void main(String[] args) throws CliException {
		new AppCli().run();
	}
}
