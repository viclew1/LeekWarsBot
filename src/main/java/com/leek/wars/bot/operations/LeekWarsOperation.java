package com.leek.wars.bot.operations;

import com.leek.wars.bot.util.LWSessionManager;
import com.leek.wars.bot.util.rest.LWRequestProcessor;

import fr.lewon.bot.operations.AbstractOperation;

public abstract class LeekWarsOperation extends AbstractOperation<LWSessionManager, LWRequestProcessor> {

	public LeekWarsOperation(LWSessionManager sessionManager, LWRequestProcessor requestProcessor) {
		super(sessionManager, requestProcessor);
	}

}
