package com.leek.wars.client.nav.actions;

import com.leek.wars.client.util.accounts.AccountHelper;

import fr.lewon.client.menus.AbstractMenu;
import fr.lewon.client.menus.Action;
import fr.lewon.client.util.input.UserInputUtil;

public class AddAccountAction extends Action {

	public AddAccountAction(AbstractMenu containingMenu) {
		super(containingMenu);
	}

	@Override
	protected AbstractMenu processAction(AbstractMenu caller) {
		String user = UserInputUtil.INSTANCE.askString("username", false, true);
		String password = UserInputUtil.INSTANCE.askString("password", true, true);
		AccountHelper.INSTANCE.addAccount(user, password);
		return caller;
	}

	@Override
	public String getLabel() {
		return "Add an account";
	}

}
