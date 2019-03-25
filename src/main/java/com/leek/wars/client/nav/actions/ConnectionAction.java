package com.leek.wars.client.nav.actions;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leek.wars.client.entities.responses.SessionResponse;
import com.leek.wars.client.nav.menus.FarmerMenu;
import com.leek.wars.client.util.accounts.AccountHelper;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.rest.RequestProcessor;

import fr.lewon.client.menus.AbstractMenu;
import fr.lewon.client.menus.Action;

public class ConnectionAction extends Action {

	private static final Logger logger = LoggerFactory.getLogger(ConnectionAction.class);
	
	private String user;
	
	public ConnectionAction(AbstractMenu containingMenu, String user) {
		super(containingMenu);
		this.user = user;
	}

	@Override
	protected AbstractMenu processAction(AbstractMenu caller) {
		try {
			SessionResponse sr = RequestProcessor.INSTANCE.getSession(user, AccountHelper.INSTANCE.getPassword(user));
			if (!sr.isSuccess()) {
				System.out.println("Connection to user " + user + " impossible.");
				return caller;
			}
			return new FarmerMenu(caller, sr.getToken(), sr.getFarmer());
		} catch (ServerException | IOException e) {
			logger.error("", e);
		}
		return caller;
	}

	@Override
	public String getLabel() {
		return "Connect account : " + user;
	}

}
