package com.leek.wars.bot.operations;

import com.leek.wars.bot.util.LWSessionManager;
import com.leek.wars.client.util.rest.RequestProcessor;

import fr.lewon.bot.runner.Operation;

public abstract class LeekWarsOperation extends Operation<LWSessionManager, RequestProcessor> {

	public LeekWarsOperation(LWSessionManager sessionManager, RequestProcessor requestProcessor) {
		super(sessionManager, requestProcessor);
	}

}
