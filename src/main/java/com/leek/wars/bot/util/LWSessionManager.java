package com.leek.wars.bot.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.message.BasicHeader;

import com.leek.wars.bot.entities.responses.SessionResponse;
import com.leek.wars.bot.util.rest.LWRequestProcessor;

import fr.lewon.bot.http.AbstractSessionManager;
import fr.lewon.bot.http.DefaultResponse;

public class LWSessionManager extends AbstractSessionManager<LWRequestProcessor, SessionResponse> {

	public LWSessionManager(String login, String password) {
		super(login, password, 3600 * 2 * 1000L);
	}

	@Override
	protected SessionResponse generateSessionObject(LWRequestProcessor requestProcessor, String login, String password) throws Exception {
		DefaultResponse<SessionResponse> defaultResponse = requestProcessor.getSession(login, password);
		SessionResponse session = defaultResponse.getEntity();

		Header[] setCookies = defaultResponse.getHttpResponse().getHeaders("Set-Cookie");
		List<HeaderElement> cookieVals = getElementsByNames(setCookies, "token", "PHPSESSID");
		String cookieVal = "";
		Iterator<HeaderElement> it = cookieVals.iterator();
		while (it.hasNext()) {
			HeaderElement he = it.next();
			cookieVal += he.getName() + "=" + he.getValue();
			if (it.hasNext()) {
				cookieVal += "; ";
			}
		}
		Header cookieHeader = new BasicHeader("Cookie", cookieVal);
		session.setCookie(cookieHeader);
		return session;
	}

	private List<HeaderElement> getElementsByNames(Header[] headers, String... elemNames) {
		List<HeaderElement> values = new ArrayList<>();
		for (Header h : headers) {
			for (HeaderElement elem : h.getElements()) {
				for (String name : elemNames) {
					if (name.equalsIgnoreCase(elem.getName())) {
						values.add(elem);
						break;
					}
				}
			}
		}
		return values;
	}

}
