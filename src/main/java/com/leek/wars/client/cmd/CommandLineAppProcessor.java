package com.leek.wars.client.cmd;

import java.io.IOException;

import com.leek.wars.client.cmd.nav.menus.AbstractMenu;
import com.leek.wars.client.cmd.nav.menus.impl.HomeMenu;
import com.leek.wars.client.util.exceptions.ServerException;

public enum CommandLineAppProcessor {

	INSTANCE;

	private CommandLineAppProcessor() {
	}

	public void start() throws ServerException, IOException {
		AbstractMenu callingMenu = null;
		AbstractMenu currentMenu = new HomeMenu();

		while (currentMenu != null) {
			AbstractMenu nextMenu = currentMenu.run(callingMenu);
			callingMenu = currentMenu;
			currentMenu = nextMenu;
		}
	}

}
