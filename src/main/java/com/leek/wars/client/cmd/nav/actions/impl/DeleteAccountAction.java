package com.leek.wars.client.cmd.nav.actions.impl;

import com.leek.wars.client.cmd.nav.actions.Action;
import com.leek.wars.client.cmd.nav.menus.AbstractMenu;
import com.leek.wars.client.util.accounts.AccountHelper;
import com.leek.wars.client.util.exceptions.ActionException;

public class DeleteAccountAction extends Action {

	private String user;
	
	public DeleteAccountAction(AbstractMenu containingMenu, String user) {
		super(containingMenu, "Delete " + user);
		this.user = user;
	}

	@Override
	protected AbstractMenu processAction(AbstractMenu caller) throws ActionException {
		AccountHelper.INSTANCE.deleteAccount(user);
		return caller;
	}

}
