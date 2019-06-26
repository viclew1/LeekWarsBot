package com.leek.wars.bot.util.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import com.leek.wars.bot.entities.input.FightInfosInput;
import com.leek.wars.bot.entities.input.LeekInfosInput;
import com.leek.wars.bot.entities.input.UserInfosInput;
import com.leek.wars.bot.entities.responses.AiResponse;
import com.leek.wars.bot.entities.responses.AisResponse;
import com.leek.wars.bot.entities.responses.FightIdResponse;
import com.leek.wars.bot.entities.responses.FightResponse;
import com.leek.wars.bot.entities.responses.LeekInfosResponse;
import com.leek.wars.bot.entities.responses.OpponentLeeksResponse;
import com.leek.wars.bot.entities.responses.SessionResponse;
import com.leek.wars.bot.util.BodyHelper;

import fr.lewon.bot.errors.ServerException;
import fr.lewon.bot.http.AbstractRequestProcessor;
import fr.lewon.bot.http.DefaultResponse;

public class LWRequestProcessor extends AbstractRequestProcessor {

	private static final String BASE_URL = "https://leekwars.com/";

	private static final String API = "/api";

	private static final String LEEK = "/leek";
	private static final String FARMER = "/farmer";
	private static final String GARDEN = "/garden";
	private static final String FIGHT = "/fight";
	private static final String AI = "/ai";

	private static final String GET = "/get";
	private static final String GET_PRIVATE = "/get-private";

	private static final String LOGIN = "/login";
	private static final String REGISTER_TOURNAMENT = "/register-tournament";
	private static final String GET_LEEK_OPPONENTS = "/get-leek-opponents";
	private static final String GET_FARMER_AIS = "/get-farmer-ais";
	private static final String START_SOLO_FIGHT = "/start-solo-fight";

	private static final String SLASH = "/";

	@Override
	protected List<Header> getNeededHeaders() {
		List<Header> headers = new ArrayList<>();
		headers.add(new BasicHeader("Accept", "*/*"));
		headers.add(new BasicHeader("Accept-Language", "fr-FR,fr;q=0.9,en-GB;q=0.8,en;q=0.7,en-US;q=0.6"));
		headers.add(new BasicHeader("Connection", "keep-alive"));
		headers.add(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"));
		headers.add(new BasicHeader("Host", "leekwars.com"));
		headers.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36"));
		headers.add(new BasicHeader("Authorization", "Bearer $"));
		return headers;
	}

	public DefaultResponse<SessionResponse> getSession(String login, String password) throws ServerException, IOException {
		String url = BASE_URL + API + FARMER + LOGIN;
		UserInfosInput ui = new UserInfosInput(login, password);
		return processPostRequest(SessionResponse.class, url, BodyHelper.INSTANCE.generateBody(ui));
	}

	public LeekInfosResponse getLeekInfos(Long leekId, Header cookie) throws IOException, ServerException {
		String url = BASE_URL + API + LEEK + GET_PRIVATE + SLASH + leekId;
		return processGetRequest(LeekInfosResponse.class, url, cookie).getEntity();
	}

	public void registerFarmerTournament(Header cookie) throws ServerException, IOException {
		String url = BASE_URL + API + FARMER + REGISTER_TOURNAMENT;
		processPostRequest(url,  null, cookie);
	}

	public void registerLeekTournament(Long leekId, Header cookie) throws ServerException, IOException {
		String url = BASE_URL + API + LEEK + REGISTER_TOURNAMENT;
		LeekInfosInput li = new LeekInfosInput(leekId);
		processPostRequest(url, BodyHelper.INSTANCE.generateBody(li), cookie);
	}

	public OpponentLeeksResponse getLeekOpponents(Long leekId, Header cookie) throws ServerException, IOException {
		String url = BASE_URL + API + GARDEN + GET_LEEK_OPPONENTS + SLASH + leekId;
		return processGetRequest(OpponentLeeksResponse.class, url, cookie).getEntity();
	}

	public FightIdResponse startLeekFight(Long leekId, Long targetId, Header cookie) throws ServerException, IOException {
		String url = BASE_URL + API + GARDEN + START_SOLO_FIGHT;
		FightInfosInput fi = new FightInfosInput(leekId, targetId);
		return processPostRequest(FightIdResponse.class, url, BodyHelper.INSTANCE.generateBody(fi), cookie).getEntity();
	}

	public void getGarden(Header cookie) throws ServerException, IOException {
		String url = BASE_URL + API + GARDEN + GET;
		readAllPageContent(url, cookie);
	}

	public FightResponse getFight(Long fightId, Header cookie) throws ServerException, IOException {
		String url = BASE_URL + API + FIGHT + GET + SLASH + fightId;
		return processGetRequest(FightResponse.class, url, cookie).getEntity();
	}

	public AisResponse getFarmerAis(Header cookie) throws ServerException, IOException {
		String url = BASE_URL + API + AI + GET_FARMER_AIS;
		return processGetRequest(AisResponse.class, url, cookie).getEntity();
	}

	public AiResponse getAi(Long aiId, Header cookie) throws ServerException, IOException {
		String url = BASE_URL + API + AI + GET + SLASH + aiId;
		return processGetRequest(AiResponse.class, url, cookie).getEntity();
	}
}
