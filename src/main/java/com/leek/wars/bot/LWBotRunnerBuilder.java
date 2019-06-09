package com.leek.wars.bot;

import java.util.ArrayList;
import java.util.List;

import fr.lewon.bot.AbstractBotRunnerBuilder;
import fr.lewon.bot.props.BotProperty;

public class LWBotRunnerBuilder extends AbstractBotRunnerBuilder<LWBot> {

	public LWBotRunnerBuilder() {
		super(new ArrayList<>(), new ArrayList<>());
	}

	@Override
	protected LWBot initBot(String login, String password, List<BotProperty> properties) {
		return new LWBot(login, password, properties);
	}

}
