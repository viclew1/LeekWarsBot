package com.leek.wars.client.util.nav.actions.impl;

import java.io.IOException;

import com.leek.wars.client.entities.Leek;
import com.leek.wars.client.entities.responses.OpponentLeeksResponse;
import com.leek.wars.client.util.UserInputUtil;
import com.leek.wars.client.util.exceptions.ActionException;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.nav.actions.Action;
import com.leek.wars.client.util.nav.menus.AbstractMenu;
import com.leek.wars.client.util.rest.RequestProcessor;

public class ManualFightAction extends Action {

	private Leek leek;
	private String token;
	
	public ManualFightAction(AbstractMenu containingMenu, String token, Leek leek) {
		super(containingMenu, "Manual Fight");
		this.leek = leek;
		this.token = token;
	}

	@Override
	public AbstractMenu processAction(AbstractMenu caller) throws ActionException {
		try {
			OpponentLeeksResponse olr = RequestProcessor.INSTANCE.getLeekOpponents(leek.getId(), token);
			Object[] choices = olr.getOpponents().stream()
					.map(Leek::toSimpleString)
					.toArray();
			int choice = UserInputUtil.INSTANCE.askChoice("Opponents : ", true, choices);
			
			if (choice == -1) {
				return caller;
			}
			
			RequestProcessor.INSTANCE.startLeekFight(leek.getId(), olr.getOpponents().get(choice).getId(), token);
		} catch (ServerException | IOException e) {
			throw new ActionException(e);
		}
		return caller;
	}

}
