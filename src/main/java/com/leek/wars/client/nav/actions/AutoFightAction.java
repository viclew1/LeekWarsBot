package com.leek.wars.client.nav.actions;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leek.wars.client.entities.Leek;
import com.leek.wars.client.entities.responses.OpponentLeeksResponse;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.rest.RequestProcessor;

import fr.lewon.client.menus.AbstractMenu;
import fr.lewon.client.menus.Action;
import fr.lewon.client.util.input.UserInputUtil;

public class AutoFightAction extends Action {

	private static final Logger logger = LoggerFactory.getLogger(AutoFightAction.class);
	
	private Leek leek;
	private String token;

	public AutoFightAction(AbstractMenu containingMenu, String token, Leek leek) {
		super(containingMenu);
		this.leek = leek;
		this.token = token;
	}

	@Override
	public AbstractMenu processAction(AbstractMenu caller) {
		try {
			Integer fightCount = UserInputUtil.INSTANCE.askInteger("fight count", false, true, 0, null);
			for (int i = 0 ; i < fightCount ; i++) {
				OpponentLeeksResponse olr = RequestProcessor.INSTANCE.getLeekOpponents(leek.getId(), token);
				if (olr.getOpponents() == null || olr.getOpponents().isEmpty()) {
					logger.error("No opponent");
					break;
				}
				RequestProcessor.INSTANCE.startLeekFight(leek.getId(), selectOpponent(olr.getOpponents()).getId(), token);
			}
		} catch (NumberFormatException | ServerException | IOException e) {
			logger.error("Auto fight error", e);
		}
		return caller;
	}

	private Leek selectOpponent(List<Leek> opponents) {
		opponents.sort((l1, l2) -> getDist(leek, l1) - getDist(leek, l2));
		return opponents.get(0);
	}

	private int getDist(Leek l1, Leek l2) {
		return Math.abs(getValue(l1) - getValue(l2));
	}
	
	private int getValue(Leek leek) {
		return leek.getLevel() * leek.getLevel() + leek.getTalent();
	}

	@Override
	public String getLabel() {
		return "Auto Fight";
	}
}
