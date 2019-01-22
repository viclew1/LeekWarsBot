package com.leek.wars.client.cmd.nav.menus.impl;

import java.util.ArrayList;
import java.util.List;

import com.leek.wars.client.cmd.nav.actions.impl.ConnectionAction;
import com.leek.wars.client.cmd.nav.menus.AbstractMenu;
import com.leek.wars.client.cmd.nav.menus.Menu;
import com.leek.wars.client.util.accounts.AccountHelper;

public class HomeMenu extends Menu {

	public HomeMenu() {
		super(null, "Home menu", null);
	}

	@Override
	protected List<AbstractMenu> getMenuOptions() {
		List<AbstractMenu> menus = new ArrayList<>();
		for (String user : AccountHelper.INSTANCE.getUsers()) {
			menus.add(new ConnectionAction(this, user));
		}
		menus.add(new ManageSavedAccountsMenu(this));
		return menus;
	}

}
