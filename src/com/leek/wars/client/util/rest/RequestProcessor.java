package com.leek.wars.client.util.rest;

import java.io.IOException;

import com.leek.wars.client.entities.Leek;
import com.leek.wars.client.entities.responses.AiResponse;
import com.leek.wars.client.entities.responses.AisResponse;
import com.leek.wars.client.entities.responses.FightIdResponse;
import com.leek.wars.client.entities.responses.FightResponse;
import com.leek.wars.client.entities.responses.OpponentLeeksResponse;
import com.leek.wars.client.entities.responses.Response;
import com.leek.wars.client.entities.responses.SessionResponse;
import com.leek.wars.client.util.GlobalProperties;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.jackson.JacksonHelper;

public enum RequestProcessor {

	INSTANCE;
	
	private static final String BASE_URL = GlobalProperties.INSTANCE.getUrl();
	private static final String LOGIN 	 = GlobalProperties.INSTANCE.getLogin();
	private static final String PASSWORD = GlobalProperties.INSTANCE.getPassword();
	
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
	
	private RequestProcessor() {}
	
	public SessionResponse getSession() throws ServerException, IOException {
		String url = BASE_URL + API + FARMER + LOGIN_TOKEN + SLASH + LOGIN + SLASH + PASSWORD;
		String response = RequestHelper.INSTANCE.processGetRequest(url);
		return JacksonHelper.INSTANCE.jsonToObject(SessionResponse.class, response);
	}
	
	public Response registerFarmerTournament(String token) throws ServerException, IOException {
		String url = BASE_URL + API + FARMER + REGISTER_TOURNAMENT + SLASH + token;
		String response = RequestHelper.INSTANCE.processGetRequest(url);
		return JacksonHelper.INSTANCE.jsonToObject(Response.class, response);
	}

	public Response registerLeekTournament(Leek leek, String token) throws ServerException, IOException {
		String url = BASE_URL + API + LEEK + REGISTER_TOURNAMENT + SLASH + leek.getId() + SLASH + token;
		String response = RequestHelper.INSTANCE.processGetRequest(url);
		return JacksonHelper.INSTANCE.jsonToObject(Response.class, response);
	}
	
	public OpponentLeeksResponse getLeekOpponents(Leek leek, String token) throws ServerException, IOException {
		String url = BASE_URL + API + GARDEN + GET_LEEK_OPPONENTS + SLASH + leek.getId() + SLASH + token;
		String response = RequestHelper.INSTANCE.processGetRequest(url);
		return JacksonHelper.INSTANCE.jsonToObject(OpponentLeeksResponse.class, response);
	}
	
	public FightIdResponse startLeekFight(Leek leek, Leek target, String token) throws ServerException, IOException {
		String url = BASE_URL + API + GARDEN + START_SOLO_FIGHT + SLASH + leek.getId() + SLASH + target.getId() + SLASH + token;
		String response = RequestHelper.INSTANCE.processGetRequest(url);
		return JacksonHelper.INSTANCE.jsonToObject(FightIdResponse.class, response);
	}
	
	public void getGarden(String token) throws ServerException, IOException {
		String url = BASE_URL + API + GARDEN + GET + SLASH + token;
		RequestHelper.INSTANCE.processGetRequest(url);
	}
	
	public FightResponse getFight(Long fightId) throws ServerException, IOException {
		String url = BASE_URL + API + FIGHT + GET + SLASH + fightId;
		String response = RequestHelper.INSTANCE.processGetRequest(url);
		return JacksonHelper.INSTANCE.jsonToObject(FightResponse.class, response);
	}
	
	public AisResponse getFarmerAis(String token) throws ServerException, IOException {
		String url = BASE_URL + API + AI + GET_FARMER_AIS + SLASH + token;
		String response = RequestHelper.INSTANCE.processGetRequest(url);
		return JacksonHelper.INSTANCE.jsonToObject(AisResponse.class, response);
	}
	
	public AiResponse getAi(Long aiId, String token) throws ServerException, IOException {
		String url = BASE_URL + API + AI + GET + SLASH + aiId + SLASH + token;
		String response = RequestHelper.INSTANCE.processGetRequest(url);
		return JacksonHelper.INSTANCE.jsonToObject(AiResponse.class, response);
	}
}
