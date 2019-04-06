package com.leek.wars.client.util.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;

import com.leek.wars.client.entities.responses.AiResponse;
import com.leek.wars.client.entities.responses.AisResponse;
import com.leek.wars.client.entities.responses.FightIdResponse;
import com.leek.wars.client.entities.responses.FightResponse;
import com.leek.wars.client.entities.responses.OpponentLeeksResponse;
import com.leek.wars.client.entities.responses.Response;
import com.leek.wars.client.entities.responses.SessionResponse;

import fr.lewon.bot.errors.ServerException;
import fr.lewon.bot.http.AbstractRequestProcessor;
import fr.lewon.bot.http.RequestHelper;

public class RequestProcessor extends AbstractRequestProcessor {

	private static final String BASE_URL = "https://leekwars.com/";

	private static final String API = "/api";

	private static final String LEEK = "/leek";
	private static final String FARMER = "/farmer";
	private static final String GARDEN = "/garden";
	private static final String FIGHT = "/fight";
	private static final String AI = "/ai";

	private static final String GET = "/get";

	private static final String LOGIN_TOKEN = "/login-token";
	private static final String REGISTER_TOURNAMENT = "/register-tournament";
	private static final String GET_LEEK_OPPONENTS = "/get-leek-opponents";
	private static final String GET_FARMER_AIS = "/get-farmer-ais";
	private static final String START_SOLO_FIGHT = "/start-solo-fight";

	private static final String SLASH = "/";

	public RequestProcessor() {
		super(new RequestHelper());
	}

	@Override
	protected List<Header> getNeededHeaders() {
		return new ArrayList<>();
	}

	public SessionResponse getSession(String login, String password) throws ServerException, IOException {
		String url = BASE_URL + API + FARMER + LOGIN_TOKEN + SLASH + login + SLASH + password;
		HttpResponse response = getRequestHelper().processGetRequest(url);
		return generateResponse(SessionResponse.class, response).getEntity();
	}

	public Response registerFarmerTournament(String token) throws ServerException, IOException {
		String url = BASE_URL + API + FARMER + REGISTER_TOURNAMENT + SLASH + token;
		HttpResponse response = getRequestHelper().processGetRequest(url);
		return generateResponse(Response.class, response).getEntity();
	}

	public Response registerLeekTournament(Long leekId, String token) throws ServerException, IOException {
		String url = BASE_URL + API + LEEK + REGISTER_TOURNAMENT + SLASH + leekId + SLASH + token;
		HttpResponse response = getRequestHelper().processGetRequest(url);
		return generateResponse(Response.class, response).getEntity();
	}

	public OpponentLeeksResponse getLeekOpponents(Long leekId, String token) throws ServerException, IOException {
		String url = BASE_URL + API + GARDEN + GET_LEEK_OPPONENTS + SLASH + leekId + SLASH + token;
		HttpResponse response = getRequestHelper().processGetRequest(url);
		return generateResponse(OpponentLeeksResponse.class, response).getEntity();
	}

	public FightIdResponse startLeekFight(Long leekId, Long targetId, String token) throws ServerException, IOException {
		String url = BASE_URL + API + GARDEN + START_SOLO_FIGHT + SLASH + leekId + SLASH + targetId + SLASH + token;
		HttpResponse response = getRequestHelper().processGetRequest(url);
		return generateResponse(FightIdResponse.class, response).getEntity();
	}

	public void getGarden(String token) throws ServerException, IOException {
		String url = BASE_URL + API + GARDEN + GET + SLASH + token;
		HttpResponse response = getRequestHelper().processGetRequest(url);
		readBody(response);
	}

	public FightResponse getFight(Long fightId) throws ServerException, IOException {
		String url = BASE_URL + API + FIGHT + GET + SLASH + fightId;
		HttpResponse response = getRequestHelper().processGetRequest(url);
		return generateResponse(FightResponse.class, response).getEntity();	}

	public AisResponse getFarmerAis(String token) throws ServerException, IOException {
		String url = BASE_URL + API + AI + GET_FARMER_AIS + SLASH + token;
		HttpResponse response = getRequestHelper().processGetRequest(url);
		return generateResponse(AisResponse.class, response).getEntity();
	}

	public AiResponse getAi(Long aiId, String token) throws ServerException, IOException {
		String url = BASE_URL + API + AI + GET + SLASH + aiId + SLASH + token;
		HttpResponse response = getRequestHelper().processGetRequest(url);
		return generateResponse(AiResponse.class, response).getEntity();
	}
}
