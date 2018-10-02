package com.leek.wars.client.util.nav.actions.impl;

import java.io.IOException;
import java.util.Map;

import com.leek.wars.client.entities.Leek;
import com.leek.wars.client.util.exceptions.ActionException;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.nav.actions.Action;
import com.leek.wars.client.util.nav.menus.AbstractMenu;
import com.leek.wars.client.util.rest.RequestProcessor;

public class RegisterAllAction extends Action {

	private String token;
	private Map<Long, Leek> leeks;
	
	public RegisterAllAction(AbstractMenu containingMenu, String token, Map<Long, Leek> leeks) {
		super(containingMenu, "Register all");
		this.token = token;
		this.leeks = leeks;
	}

	@Override
	protected AbstractMenu processAction(AbstractMenu caller) throws ActionException {
		for (Long id : leeks.keySet()) {
			try {
				RequestProcessor.INSTANCE.registerLeekTournament(id, token);
			} catch (ServerException | IOException e) {
				throw new ActionException(e);
			}
		}
		return caller;
	}
}
