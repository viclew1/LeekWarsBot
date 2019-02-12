package com.leek.wars.client.nav.menus;

import java.util.ArrayList;
import java.util.List;

import com.leek.wars.client.nav.actions.AddAccountAction;
import com.leek.wars.client.nav.actions.DeleteAccountAction;
import com.leek.wars.client.util.accounts.AccountHelper;

import fr.lewon.client.menus.AbstractMenu;
import fr.lewon.client.menus.Menu;

public class ManageSavedAccountsMenu extends Menu {

	public ManageSavedAccountsMenu(AbstractMenu containingMenu) {
		super(containingMenu, "Manage saved accounts", null);
	}

	@Override
	protected List<AbstractMenu> getMenuOptions() {
		List<AbstractMenu> menus = new ArrayList<>();
		for (String user : AccountHelper.INSTANCE.getUsers()) {
			menus.add(new DeleteAccountAction(this, user));
		}
		menus.add(new AddAccountAction(this));
		return menus;
	}

}
