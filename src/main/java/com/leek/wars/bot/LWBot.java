package com.leek.wars.bot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.leek.wars.bot.operations.DefaultLeekWarsOperation;
import com.leek.wars.bot.util.LWSessionManager;
import com.leek.wars.bot.util.rest.LWRequestProcessor;

import fr.lewon.bot.AbstractBot;
import fr.lewon.bot.props.BotProperty;
import fr.lewon.bot.runner.BotRunner;
import fr.lewon.bot.runner.Operation;

public class LWBot extends AbstractBot<LWSessionManager, LWRequestProcessor> {

	public LWBot(String login, String password, List<BotProperty> properties) {
		super(new LWRequestProcessor(), login, password, new ArrayList<>());
	}

	@Override
	protected LWSessionManager initSessionManager(LWRequestProcessor requestProcessor, String login, String password) {
		return new LWSessionManager(requestProcessor, login, password);
	}

	@Override
	protected List<Operation<LWSessionManager, LWRequestProcessor>> getDefaultOperations(BotRunner runner, LWSessionManager sessionManager, LWRequestProcessor requestProcessor) {
		return Arrays.asList(new DefaultLeekWarsOperation(sessionManager, requestProcessor));
	}

}
