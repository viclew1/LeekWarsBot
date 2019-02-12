package com.leek.wars.client.nav.menus;

import java.util.ArrayList;
import java.util.List;

import com.leek.wars.client.nav.actions.ConnectionAction;
import com.leek.wars.client.util.accounts.AccountHelper;

import fr.lewon.client.menus.AbstractMenu;
import fr.lewon.client.menus.Menu;

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
