package com.leek.wars.bot.util

import com.leek.wars.bot.entities.responses.SessionResponse
import com.leek.wars.bot.util.rest.LWRequestProcessor
import fr.lewon.bot.runner.session.AbstractSessionManager
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

class LWSessionManager(login: String, password: String, webClientBuilder: WebClient.Builder) :
        AbstractSessionManager(login, password, 3600 * 2 * 1000L, webClientBuilder) {

    override fun generateSessionObject(webClient: WebClient, login: String, password: String): Any {
        val connectResponse = LWRequestProcessor().getSession(webClient, login, password)
        val session = connectResponse
                ?.bodyToMono<SessionResponse>()
                ?.block() ?: throw Exception("Unable to connect to Leek wars, unknown error")


        session.cookieValue = connectResponse.cookies()
                .getFirst("token")
                .let { "${it.name}=${it.value}" }
                .plus("; ")
                .plus(connectResponse.headers().asHttpHeaders()
                        .getFirst("Set-Cookie") ?: "")
        session.cookieName = "Cookie"

        connectResponse.releaseBody()
        return session
    }

}