package com.leek.wars.client.nav.actions;

import com.leek.wars.client.util.accounts.AccountHelper;

import fr.lewon.client.menus.AbstractMenu;
import fr.lewon.client.menus.Action;

public class DeleteAccountAction extends Action {

	private String user;
	
	public DeleteAccountAction(AbstractMenu containingMenu, String user) {
		super(containingMenu);
		this.user = user;
	}

	@Override
	protected AbstractMenu processAction(AbstractMenu caller) {
		AccountHelper.INSTANCE.deleteAccount(user);
		return caller;
	}

	@Override
	public String getLabel() {
		return "Delete " + user;
	}

}
