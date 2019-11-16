package com.leek.wars.bot;

import com.leek.wars.bot.operations.DefaultLeekWarsOperation;
import com.leek.wars.bot.util.LWSessionManager;
import com.leek.wars.bot.util.rest.LWRequestProcessor;
import fr.lewon.bot.bots.web.AbstractWebBot;
import fr.lewon.bot.operations.AbstractOperation;
import fr.lewon.bot.props.BotPropertyStore;

public class LWBot extends AbstractWebBot<LWBot, LWRequestProcessor, LWSessionManager> {

    public LWBot(String login, String password, BotPropertyStore properties) {
        super(login, password, properties);
    }

    @Override
    protected LWSessionManager initSessionManager(String login, String password) {
        return new LWSessionManager(login, password);
    }


    @Override
    protected LWRequestProcessor initRequestProcessor() {
        return new LWRequestProcessor();
    }


    @Override
    public AbstractOperation<LWBot> getInitialOperation() {
        return new DefaultLeekWarsOperation();
    }
}
