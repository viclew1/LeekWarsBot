package com.leek.wars.client.cmd.nav.actions.impl;

import java.io.IOException;

import com.leek.wars.client.cmd.nav.actions.Action;
import com.leek.wars.client.cmd.nav.menus.AbstractMenu;
import com.leek.wars.client.cmd.nav.menus.impl.FarmerMenu;
import com.leek.wars.client.entities.responses.SessionResponse;
import com.leek.wars.client.util.accounts.AccountHelper;
import com.leek.wars.client.util.exceptions.ActionException;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.rest.RequestProcessor;

public class ConnectionAction extends Action {

	private String user;
	
	public ConnectionAction(AbstractMenu containingMenu, String user) {
		super(containingMenu, "Connect account : " + user);
		this.user = user;
	}

	@Override
	protected AbstractMenu processAction(AbstractMenu caller) throws ActionException {
		try {
			SessionResponse sr = RequestProcessor.INSTANCE.getSession(user, AccountHelper.INSTANCE.getPassword(user));
			if (!sr.isSuccess()) {
				System.out.println("Connection to user " + user + " impossible.");
				return caller;
			}
			return new FarmerMenu(caller, sr.getToken(), sr.getFarmer());
		} catch (ServerException | IOException e) {
			throw new ActionException(e);
		}
	}

}
