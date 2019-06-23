package com.leek.wars.bot;

import java.util.ArrayList;
import java.util.HashMap;

import fr.lewon.bot.AbstractBotRunnerBuilder;
import fr.lewon.bot.props.BotPropertyStore;

public class LWBotRunnerBuilder extends AbstractBotRunnerBuilder<LWBot> {

	public LWBotRunnerBuilder() {
		super(new ArrayList<>(), new HashMap<>());
	}

	@Override
	protected LWBot initBot(String login, String password, BotPropertyStore properties) {
		return new LWBot(login, password, properties);
	}

}
