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

	private Leek leek;
	private String token;
	private Integer fightCount;

	public AutoFightAction(AbstractMenu containingMenu, String token, Leek leek, Integer fightCount) {
		super(containingMenu, "Auto Fight");
		this.leek = leek;
		this.token = token;
		this.fightCount = fightCount;
	}

	@Override
	public AbstractMenu processAction(AbstractMenu caller) throws ActionException {
		try {
			for (int i = 0 ; i < fightCount ; i++) {
				OpponentLeeksResponse olr = RequestProcessor.INSTANCE.getLeekOpponents(leek.getId(), token);
				RequestProcessor.INSTANCE.startLeekFight(leek.getId(), selectOpponent(olr.getOpponents()).getId(), token);
			}
		} catch (NumberFormatException | ServerException | IOException e) {
			throw new ActionException(e);
		}
		return caller;
	}

	private Leek selectOpponent(List<Leek> opponents) throws ActionException {
		if (opponents == null || opponents.isEmpty()) {
			throw new ActionException("No opponent");
		}

		opponents.sort((l1, l2) -> getDist(leek, l1) - getDist(leek, l2));
		return opponents.get(0);
	}

	private int getDist(Leek l1, Leek l2) {
		return Math.abs(getValue(l1) - getValue(l2));
	}
	
	private int getValue(Leek leek) {
		return leek.getLevel() * leek.getLevel() + leek.getTalent();
	}
}
