package com.leek.wars.bot.util

import com.leek.wars.bot.entities.responses.SessionResponse
import com.leek.wars.bot.util.rest.LWRequestProcessor
import fr.lewon.bot.runner.session.AbstractSessionManager
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

class LWSessionManager(login: String, password: String, webClientBuilder: WebClient.Builder) :
        AbstractSessionManager(login, password, 3600 * 2 * 1000L, webClientBuilder) {

    override fun generateSessionObject(webClient: WebClient, login: String, password: String): Any {
        val connectResponse = LWRequestProcessor().getSession(getWebClient(), login, password)
        val session = connectResponse
                ?.bodyToMono<SessionResponse>()
                ?.block() ?: throw Exception("Impossible to connect to Leek wars")
        val cookieValues = HashMap<String, String>()
        cookieValues.putAll(connectResponse.cookies().map { e ->
            e.key to e.value.joinToString(separator = "; ") { it.value }
        })
        session.cookieValue = cookieValues.map { "${it.key}=${it.value}" }
                .joinToString(separator = "; ")
        session.cookieName = "Cookie"
        return session
    }

}