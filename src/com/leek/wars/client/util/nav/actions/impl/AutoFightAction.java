package com.leek.wars.client.util.nav.actions.impl;

import java.io.IOException;
import java.util.List;

import com.leek.wars.client.entities.Leek;
import com.leek.wars.client.entities.responses.OpponentLeeksResponse;
import com.leek.wars.client.util.exceptions.ActionException;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.nav.actions.Action;
import com.leek.wars.client.util.nav.menus.AbstractMenu;
import com.leek.wars.client.util.rest.RequestProcessor;

public class AutoFightAction extends Action {

	private Long leekId;
	private String token;
	
	public AutoFightAction(AbstractMenu containingMenu, Long leekId, String token) {
		super(containingMenu, "Auto Fight");
		this.leekId = leekId;
		this.token = token;
	}

	@Override
	public AbstractMenu processAction(AbstractMenu caller) throws ActionException {
		try {
			OpponentLeeksResponse olr = RequestProcessor.INSTANCE.getLeekOpponents(leekId, token);
			RequestProcessor.INSTANCE.startLeekFight(leekId, selectOpponent(olr.getOpponents()).getId(), token);
		} catch (ServerException | IOException e) {
			throw new ActionException(e);
		}
		return caller;
	}
	
	private Leek selectOpponent(List<Leek> opponents) throws ActionException {
		if (opponents == null || opponents.isEmpty()) {
			throw new ActionException("No opponent");
		}
		
		opponents.sort((l1, l2) -> getValue(l1) - getValue(l2));
		return opponents.get(0);
	}
	
	private int getValue(Leek leek) {
		return leek.getLevel() * leek.getLevel() + leek.getTalent();
	}
}
