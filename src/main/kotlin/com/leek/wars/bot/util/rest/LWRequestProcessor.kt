package com.leek.wars.bot.util.rest

import com.leek.wars.bot.entities.input.FightInfosInput
import com.leek.wars.bot.entities.input.LeekInfosInput
import com.leek.wars.bot.entities.input.UserInfosInput
import com.leek.wars.bot.entities.responses.FightIdResponse
import com.leek.wars.bot.entities.responses.LeekInfosResponse
import com.leek.wars.bot.entities.responses.OpponentLeeksResponse
import com.leek.wars.bot.entities.responses.SessionResponse
import fr.lewon.bot.runner.session.helpers.FUEBodyBuilder
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient

class LWRequestProcessor {

    fun getSession(webClient: WebClient, login: String, password: String): ClientResponse? {
        return webClient.post()
            .uri(API + FARMER + LOGIN)
            .bodyValue(FUEBodyBuilder.generateBody(UserInfosInput(login, password)))
            .exchange()
            .block()
    }

    fun getLeekInfos(webClient: WebClient, session: SessionResponse, leekId: Long): LeekInfosResponse? {
        return webClient.get()
            .uri(API + LEEK + GET_PRIVATE + SLASH + leekId)
            .header(session.cookieName, session.cookieValue)
            .retrieve()
            .bodyToMono(LeekInfosResponse::class.java)
            .block()
    }

    fun registerLeekTournament(webClient: WebClient, session: SessionResponse, id: Long) {
        webClient.post()
            .uri(API + LEEK + REGISTER_TOURNAMENT)
            .header(session.cookieName, session.cookieValue)
            .bodyValue(FUEBodyBuilder.generateBody(LeekInfosInput(id)))
            .retrieve()
            .toBodilessEntity()
            .block()
    }

    fun getLeekOpponents(webClient: WebClient, session: SessionResponse, leekId: Long): OpponentLeeksResponse? {
        return webClient.get()
            .uri(API + GARDEN + GET_LEEK_OPPONENTS + SLASH + leekId)
            .header(session.cookieName, session.cookieValue)
            .retrieve()
            .bodyToMono(OpponentLeeksResponse::class.java)
            .block()
    }

    fun startLeekFight(webClient: WebClient, session: SessionResponse, leekId: Long, targetId: Long): FightIdResponse? {
        return webClient.post()
            .uri(API + GARDEN + START_SOLO_FIGHT)
            .header(session.cookieName, session.cookieValue)
            .bodyValue(FUEBodyBuilder.generateBody(FightInfosInput(leekId, targetId)))
            .retrieve()
            .bodyToMono(FightIdResponse::class.java)
            .block()
    }


    companion object {
        private const val API = "/api"
        private const val LEEK = "/leek"
        private const val FARMER = "/farmer"
        private const val GARDEN = "/garden"
        private const val GET_PRIVATE = "/get-private"
        private const val LOGIN = "/login"
        private const val REGISTER_TOURNAMENT = "/register-tournament"
        private const val GET_LEEK_OPPONENTS = "/get-leek-opponents"
        private const val START_SOLO_FIGHT = "/start-solo-fight"
        private const val SLASH = "/"
    }
}