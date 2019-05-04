package com.leek.wars.bot.operations;

import com.leek.wars.bot.util.LWSessionManager;
import com.leek.wars.bot.util.rest.LWRequestProcessor;

import fr.lewon.bot.runner.Operation;

public abstract class LeekWarsOperation extends Operation<LWSessionManager, LWRequestProcessor> {

	public LeekWarsOperation(LWSessionManager sessionManager, LWRequestProcessor requestProcessor) {
		super(sessionManager, requestProcessor);
	}

}
