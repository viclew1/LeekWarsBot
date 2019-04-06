package com.leek.wars.bot.util;

import com.leek.wars.client.entities.responses.SessionResponse;
import com.leek.wars.client.util.rest.RequestProcessor;

import fr.lewon.bot.http.AbstractSessionManager;

public class LWSessionManager extends AbstractSessionManager<RequestProcessor, SessionResponse> {

	public LWSessionManager(RequestProcessor requestProcessor, String login, String password) {
		super(requestProcessor, login, password, 3600 * 2 * 1000L);
	}

	@Override
	protected SessionResponse generateSessionObject(RequestProcessor requestProcessor, String login, String password) throws Exception {
		return requestProcessor.getSession(login, password);
	}

}
