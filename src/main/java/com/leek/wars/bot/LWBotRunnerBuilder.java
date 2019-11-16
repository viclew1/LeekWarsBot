package com.leek.wars.bot;

import fr.lewon.bot.AbstractBotRunnerBuilder;
import fr.lewon.bot.props.BotPropertyStore;

import java.util.ArrayList;

public class LWBotRunnerBuilder extends AbstractBotRunnerBuilder<LWBot> {

    public LWBotRunnerBuilder() {
        super(new ArrayList<>(), new ArrayList<>());
    }

    @Override
    protected LWBot buildBot(String login, String password, BotPropertyStore properties) {
        return new LWBot(login, password, properties);
    }

}
