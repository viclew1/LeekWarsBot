package com.leek.wars.bot.operations;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.http.Header;

import com.leek.wars.bot.entities.Leek;
import com.leek.wars.bot.entities.responses.LeekInfosResponse;
import com.leek.wars.bot.entities.responses.OpponentLeeksResponse;
import com.leek.wars.bot.entities.responses.SessionResponse;
import com.leek.wars.bot.util.LWSessionManager;
import com.leek.wars.bot.util.rest.LWRequestProcessor;

import fr.lewon.bot.errors.ServerException;
import fr.lewon.bot.runner.BotRunner;
import fr.lewon.bot.runner.Delay;
import fr.lewon.bot.runner.TimeScale;

public class DefaultLeekWarsOperation extends LeekWarsOperation {

	public DefaultLeekWarsOperation(LWSessionManager manager, LWRequestProcessor requestProcessor) {
		super(manager, requestProcessor);
	}

	@Override
	public Delay doProcess(BotRunner runner, LWSessionManager sessionManager, LWRequestProcessor requestProcessor)
			throws Exception {

		SessionResponse session = sessionManager.getSession();
		Header cookie = session.getCookie();
		int fightsCount = session.getFarmer().getFights();
		Collection<Leek> leeks = session.getFarmer().getLeeks().values();
		int fightsPerLeek = fightsCount / leeks.size();
		for (Leek l : leeks) {
			LeekInfosResponse lir = requestProcessor.getLeekInfos(l.getId(), cookie);
			if (!lir.getTournament().getRegistered()) {
				requestProcessor.registerLeekTournament(l.getId(), cookie);
				runner.logInfo("Leek {} now registered for next tournament.", l.getName());
			} else {
				runner.logInfo("Leek {} already registered for next tournament.", l.getName());
			}
			processFight(requestProcessor, l, cookie, fightsPerLeek);
			runner.logInfo("Leek {} fought {} fights.", l.getName(), fightsPerLeek);
		}
		runner.logInfo("All operations done. Trying again in 1 day");
		return new Delay(1, TimeScale.DAYS);
	}

	private void processFight(LWRequestProcessor requestProcessor, Leek leek, Header cookie, int count) throws ServerException, IOException {
		for (int i = 0 ; i < count ; i++) {
			OpponentLeeksResponse olr = requestProcessor.getLeekOpponents(leek.getId(), cookie);
			if (olr.getOpponents() == null || olr.getOpponents().isEmpty()) {
				break;
			}
			requestProcessor.startLeekFight(leek.getId(), selectOpponent(leek, olr.getOpponents()).getId(), cookie);
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
