package com.leek.wars.client.cmd.nav.menus.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.leek.wars.client.cmd.nav.actions.impl.AddAccountAction;
import com.leek.wars.client.cmd.nav.actions.impl.DeleteAccountAction;
import com.leek.wars.client.cmd.nav.menus.AbstractMenu;
import com.leek.wars.client.cmd.nav.menus.Menu;
import com.leek.wars.client.util.accounts.AccountHelper;
import com.leek.wars.client.util.exceptions.ServerException;

public class ManageSavedAccountsMenu extends Menu {

	public ManageSavedAccountsMenu(AbstractMenu containingMenu) {
		super(containingMenu, "Manage saved accounts", null);
	}

	@Override
	protected List<AbstractMenu> getMenuOptions() throws ServerException, IOException {
		List<AbstractMenu> menus = new ArrayList<>();
		for (String user : AccountHelper.INSTANCE.getUsers()) {
			menus.add(new DeleteAccountAction(this, user));
		}
		menus.add(new AddAccountAction(this));
		return menus;
	}

}
