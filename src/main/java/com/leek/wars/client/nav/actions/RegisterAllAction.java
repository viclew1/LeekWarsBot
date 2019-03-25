package com.leek.wars.client.nav.actions;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leek.wars.client.entities.Leek;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.rest.RequestProcessor;

import fr.lewon.client.menus.AbstractMenu;
import fr.lewon.client.menus.Action;

public class RegisterAllAction extends Action {

	private static final Logger logger = LoggerFactory.getLogger(RegisterAllAction.class);
	
	private String token;
	private Map<Long, Leek> leeks;
	
	public RegisterAllAction(AbstractMenu containingMenu, String token, Map<Long, Leek> leeks) {
		super(containingMenu);
		this.token = token;
		this.leeks = leeks;
	}

	@Override
	protected AbstractMenu processAction(AbstractMenu caller) {
		for (Long id : leeks.keySet()) {
			try {
				RequestProcessor.INSTANCE.registerLeekTournament(id, token);
			} catch (ServerException | IOException e) {
				logger.error("", e);
			}
		}
		return caller;
	}

	@Override
	public String getLabel() {
		return "Register all";
	}
}
