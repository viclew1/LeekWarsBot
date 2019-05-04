package com.leek.wars.bot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.leek.wars.bot.operations.DefaultLeekWarsOperation;
import com.leek.wars.bot.util.LWSessionManager;
import com.leek.wars.bot.util.rest.LWRequestProcessor;

import fr.lewon.bot.AbstractBot;
import fr.lewon.bot.methods.AbstractBotMethod;
import fr.lewon.bot.props.IBotProperty;
import fr.lewon.bot.runner.BotRunner;
import fr.lewon.bot.runner.Operation;

public class LWBot extends AbstractBot<LWSessionManager, LWRequestProcessor> {

	public LWBot() {
		super(new LWRequestProcessor());
	}

	@Override
	protected LWSessionManager initSessionManager(LWRequestProcessor requestProcessor, String login, String password) {
		return new LWSessionManager(requestProcessor, login, password);
	}

	@Override
	protected List<AbstractBotMethod<?, ?>> initBotMethods(LWSessionManager sessionManager, LWRequestProcessor requestProcessor) {
		return new ArrayList<>();
	}

	@Override
	protected List<Operation<?, ?>> initDefaultOperations(BotRunner runner, LWSessionManager sessionManager, LWRequestProcessor requestProcessor) {
		return Arrays.asList(new DefaultLeekWarsOperation(sessionManager, requestProcessor));
	}

	@Override
	protected List<IBotProperty> initProperties() {
		return null;
	}
}
