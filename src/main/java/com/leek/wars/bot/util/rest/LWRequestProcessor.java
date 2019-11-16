package com.leek.wars.bot.util.rest;

import com.leek.wars.bot.entities.input.FightInfosInput;
import com.leek.wars.bot.entities.input.LeekInfosInput;
import com.leek.wars.bot.entities.input.UserInfosInput;
import com.leek.wars.bot.entities.responses.*;
import fr.lewon.bot.errors.ServerException;
import fr.lewon.bot.http.DefaultResponse;
import fr.lewon.bot.http.RequestProcessor;
import fr.lewon.bot.http.body.HttpBodyBuilder;
import fr.lewon.bot.http.body.urlencoded.FUEBuilder;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LWRequestProcessor extends RequestProcessor {

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

    private HttpBodyBuilder bodyBuilder = new FUEBuilder();

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

    public DefaultResponse<SessionResponse> getSession(String login, String password) throws Exception {
        String url = BASE_URL + API + FARMER + LOGIN;
        UserInfosInput ui = new UserInfosInput(login, password);
        return this.processPostRequest(SessionResponse.class, url, this.bodyBuilder.generateBody(ui));
    }

    public LeekInfosResponse getLeekInfos(Long leekId, Header cookie) throws IOException, ServerException {
        String url = BASE_URL + API + LEEK + GET_PRIVATE + SLASH + leekId;
        return this.processGetRequest(LeekInfosResponse.class, url, cookie).getEntity();
    }

    public void registerFarmerTournament(Header cookie) throws ServerException, IOException {
        String url = BASE_URL + API + FARMER + REGISTER_TOURNAMENT;
        this.processPostRequest(url, null, cookie);
    }

    public void registerLeekTournament(Long leekId, Header cookie) throws Exception {
        String url = BASE_URL + API + LEEK + REGISTER_TOURNAMENT;
        LeekInfosInput li = new LeekInfosInput(leekId);
        this.processPostRequest(url, this.bodyBuilder.generateBody(li), cookie);
    }

    public OpponentLeeksResponse getLeekOpponents(Long leekId, Header cookie) throws ServerException, IOException {
        String url = BASE_URL + API + GARDEN + GET_LEEK_OPPONENTS + SLASH + leekId;
        return this.processGetRequest(OpponentLeeksResponse.class, url, cookie).getEntity();
    }

    public FightIdResponse startLeekFight(Long leekId, Long targetId, Header cookie) throws Exception {
        String url = BASE_URL + API + GARDEN + START_SOLO_FIGHT;
        FightInfosInput fi = new FightInfosInput(leekId, targetId);
        return this.processPostRequest(FightIdResponse.class, url, this.bodyBuilder.generateBody(fi), cookie).getEntity();
    }

    public void getGarden(Header cookie) throws ServerException, IOException {
        String url = BASE_URL + API + GARDEN + GET;
        this.readAllPageContent(url, cookie);
    }

    public FightResponse getFight(Long fightId, Header cookie) throws ServerException, IOException {
        String url = BASE_URL + API + FIGHT + GET + SLASH + fightId;
        return this.processGetRequest(FightResponse.class, url, cookie).getEntity();
    }

    public AisResponse getFarmerAis(Header cookie) throws ServerException, IOException {
        String url = BASE_URL + API + AI + GET_FARMER_AIS;
        return this.processGetRequest(AisResponse.class, url, cookie).getEntity();
    }

    public AiResponse getAi(Long aiId, Header cookie) throws ServerException, IOException {
        String url = BASE_URL + API + AI + GET + SLASH + aiId;
        return this.processGetRequest(AiResponse.class, url, cookie).getEntity();
    }
}
