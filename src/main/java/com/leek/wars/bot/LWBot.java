package com.leek.wars.bot;

import java.util.Arrays;
import java.util.List;

import com.leek.wars.bot.operations.DefaultLeekWarsOperation;
import com.leek.wars.bot.util.LWSessionManager;
import com.leek.wars.bot.util.rest.LWRequestProcessor;

import fr.lewon.bot.AbstractBot;
import fr.lewon.bot.operations.AbstractOperation;
import fr.lewon.bot.props.BotPropertyStore;
import fr.lewon.bot.runner.BotRunner;

public class LWBot extends AbstractBot<LWSessionManager, LWRequestProcessor> {

	public LWBot(String login, String password, BotPropertyStore properties) {
		super(login, password, properties);
	}

	@Override
	protected LWSessionManager initSessionManager(LWRequestProcessor requestProcessor, String login, String password) {
		return new LWSessionManager(requestProcessor, login, password);
	}

	@Override
	protected List<AbstractOperation<LWSessionManager, LWRequestProcessor>> getDefaultOperations(BotRunner runner, LWSessionManager sessionManager, LWRequestProcessor requestProcessor) {
		return Arrays.asList(new DefaultLeekWarsOperation(sessionManager, requestProcessor));
	}

	@Override
	protected LWRequestProcessor initRequestProcessor() {
		return new LWRequestProcessor();
	}

}
