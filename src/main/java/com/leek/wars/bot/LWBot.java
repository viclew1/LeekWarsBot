package com.leek.wars.bot;

import java.util.Arrays;
import java.util.List;

import com.leek.wars.bot.operations.DefaultLeekWarsOperation;
import com.leek.wars.bot.util.LWSessionManager;

import fr.lewon.bot.AbstractBot;
import fr.lewon.bot.runner.BotRunner;
import fr.lewon.bot.runner.Operation;

public class LWBot extends AbstractBot {

	@Override
	public List<Operation> getDefaultOperations(BotRunner runner, String login, String password) {
		return Arrays.asList(new DefaultLeekWarsOperation(runner, new LWSessionManager(login, password)));
	}

}
