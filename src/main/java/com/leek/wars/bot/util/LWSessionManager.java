package com.leek.wars.bot.util;

import com.leek.wars.client.entities.responses.SessionResponse;
import com.leek.wars.client.util.rest.RequestProcessor;

import fr.lewon.bot.http.AbstractSessionManager;

public class LWSessionManager extends AbstractSessionManager<SessionResponse> {

	public LWSessionManager(String login, String password) {
		super(login, password, 3600 * 2 * 1000L);
	}

	@Override
	protected SessionResponse generateSessionObject(String login, String password) throws Exception {
		return RequestProcessor.INSTANCE.getSession(login, password);
	}

}
