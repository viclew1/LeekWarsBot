package com.leek.wars.client.nav.actions;

import com.leek.wars.client.util.UserInputUtil;
import com.leek.wars.client.util.accounts.AccountHelper;

import fr.lewon.client.menus.AbstractMenu;
import fr.lewon.client.menus.Action;

public class AddAccountAction extends Action {

	public AddAccountAction(AbstractMenu containingMenu) {
		super(containingMenu, "Add an account");
	}

	@Override
	protected AbstractMenu processAction(AbstractMenu caller) {
		String user = UserInputUtil.INSTANCE.askString("username", false, true);
		String password = UserInputUtil.INSTANCE.askString("password", true, true);
		AccountHelper.INSTANCE.addAccount(user, password);
		return caller;
	}

}
