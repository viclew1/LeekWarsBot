package com.leek.wars.bot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.leek.wars.bot.operations.DefaultLeekWarsOperation;
import com.leek.wars.bot.util.LWSessionManager;

import fr.lewon.bot.AbstractBot;
import fr.lewon.bot.http.AbstractSessionManager;
import fr.lewon.bot.methods.AbstractBotMethod;
import fr.lewon.bot.runner.BotRunner;
import fr.lewon.bot.runner.Operation;

public class LWBot extends AbstractBot {

	@Override
	protected List<AbstractBotMethod> initBotMethods(AbstractSessionManager<?> sessionManager) {
		return new ArrayList<>();
	}

	@Override
	protected List<Operation> initDefaultOperations(BotRunner runner, AbstractSessionManager<?> sessionManager) {
		return Arrays.asList(new DefaultLeekWarsOperation((LWSessionManager) sessionManager));
	}

	@Override
	protected AbstractSessionManager<?> initSessionManager(String login, String password) {
		return new LWSessionManager(login, password);
	}

}
