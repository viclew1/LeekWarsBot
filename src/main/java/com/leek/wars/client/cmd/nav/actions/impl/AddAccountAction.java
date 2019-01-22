package com.leek.wars.client.cmd.nav.actions.impl;

import com.leek.wars.client.cmd.nav.actions.Action;
import com.leek.wars.client.cmd.nav.menus.AbstractMenu;
import com.leek.wars.client.util.UserInputUtil;
import com.leek.wars.client.util.accounts.AccountHelper;
import com.leek.wars.client.util.exceptions.ActionException;

public class AddAccountAction extends Action {

	public AddAccountAction(AbstractMenu containingMenu) {
		super(containingMenu, "Add an account");
	}

	@Override
	protected AbstractMenu processAction(AbstractMenu caller) throws ActionException {
		String user = UserInputUtil.INSTANCE.askString("username", false, true);
		String password = UserInputUtil.INSTANCE.askString("password", true, true);
		AccountHelper.INSTANCE.addAccount(user, password);
		return caller;
	}

}
