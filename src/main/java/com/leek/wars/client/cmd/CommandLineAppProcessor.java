package com.leek.wars.client.cmd;

import java.io.IOException;

import com.leek.wars.client.cmd.nav.menus.AbstractMenu;
import com.leek.wars.client.cmd.nav.menus.impl.HomeMenu;
import com.leek.wars.client.entities.responses.SessionResponse;
import com.leek.wars.client.util.GlobalProperties;
import com.leek.wars.client.util.UserInputUtil;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.rest.RequestProcessor;

public enum CommandLineAppProcessor {

	INSTANCE;

	private CommandLineAppProcessor() {
	}

	public void start() throws ServerException, IOException {
		String login = GlobalProperties.INSTANCE.getLogin();
		if (login == null) {
			UserInputUtil.INSTANCE.askString("login", false, true);
		}
		String password = GlobalProperties.INSTANCE.getPassword();
		if (password == null) {
			UserInputUtil.INSTANCE.askString("password", true, true);
		}

		SessionResponse sr = RequestProcessor.INSTANCE.getSession(login, password);
		AbstractMenu callingMenu = null;
		AbstractMenu currentMenu = new HomeMenu(null, sr);

		while (currentMenu != null) {
			AbstractMenu nextMenu = currentMenu.run(callingMenu);
			callingMenu = currentMenu;
			currentMenu = nextMenu;
		}
	}

}
