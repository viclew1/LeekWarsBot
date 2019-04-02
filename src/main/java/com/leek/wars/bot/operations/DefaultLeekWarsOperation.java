package com.leek.wars.bot.operations;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import com.leek.wars.bot.util.LWSessionManager;
import com.leek.wars.client.entities.Leek;
import com.leek.wars.client.entities.responses.OpponentLeeksResponse;
import com.leek.wars.client.entities.responses.SessionResponse;
import com.leek.wars.client.util.rest.RequestProcessor;

import fr.lewon.bot.errors.ServerException;
import fr.lewon.bot.runner.BotRunner;
import fr.lewon.bot.runner.Delay;
import fr.lewon.bot.runner.Operation;
import fr.lewon.bot.runner.TimeScale;

public class DefaultLeekWarsOperation extends Operation {

	private final LWSessionManager sessionManager;

	public DefaultLeekWarsOperation(LWSessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

	@Override
	public Delay process(BotRunner runner) throws Exception {
		SessionResponse session = sessionManager.getSession();
		int fightsCount = session.getFarmer().getFights();
		Collection<Leek> leeks = session.getFarmer().getLeeks().values();
		int fightsPerLeek = fightsCount / 3;
		for (Leek l : leeks) {
			RequestProcessor.INSTANCE.registerLeekTournament(l.getId(), session.getToken());
			processFight(l, session.getToken(), fightsPerLeek);
		}
		return new Delay(1, TimeScale.DAYS);
	}

	private void processFight(Leek leek, String token, int count) throws ServerException, IOException {
		for (int i = 0 ; i < count ; i++) {
			OpponentLeeksResponse olr = RequestProcessor.INSTANCE.getLeekOpponents(leek.getId(), token);
			if (olr.getOpponents() == null || olr.getOpponents().isEmpty()) {
				break;
			}
			RequestProcessor.INSTANCE.startLeekFight(leek.getId(), selectOpponent(leek, olr.getOpponents()).getId(), token);
		}
	}

	private Leek selectOpponent(Leek leek, List<Leek> opponents) {
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
