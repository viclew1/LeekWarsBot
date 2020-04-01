package com.leek.wars.bot.operations

import com.leek.wars.bot.entities.Leek
import com.leek.wars.bot.entities.responses.SessionResponse
import com.leek.wars.bot.util.rest.LWRequestProcessor
import fr.lewon.bot.runner.Bot
import fr.lewon.bot.runner.bot.task.BotTask
import fr.lewon.bot.runner.bot.task.Delay
import fr.lewon.bot.runner.bot.task.TaskResult
import org.springframework.web.reactive.function.client.WebClient
import java.util.concurrent.TimeUnit
import kotlin.math.abs

class DefaultLeekWarsTask(bot: Bot) : BotTask("Fights and tournament register", bot) {

    override fun doExecute(): TaskResult {
        val webClient = bot.sessionManager.getWebClient()
        val session = bot.sessionManager.getSession() as SessionResponse
        val fightsCount = session.farmer?.fights ?: 0
        val leeks = session.farmer?.leeks?.values ?: emptyList()
        if (leeks.isEmpty()) {
            logger.info("No leek found, trying again in 1 day")
            return TaskResult(Delay(1, TimeUnit.DAYS))
        }

        val fightsPerLeek = fightsCount / leeks.size
        val requestProcessor = LWRequestProcessor()
        for (l in leeks) {
            val lir = requestProcessor.getLeekInfos(webClient, session, l.id)
            if (lir?.tournament?.registered == false) {
                requestProcessor.registerLeekTournament(webClient, session, l.id)
                logger.info("Leek [${l.name}] now registered for next tournament")
            } else {
                logger.info("Leek [${l.name}] already registered for next tournament")
            }
            processFight(webClient, session, requestProcessor, l, fightsPerLeek)
            logger.info("Leek [${l.name}] fought $fightsPerLeek fights")
        }
        logger.info("All operations done. Next run in 1 day")
        return TaskResult(Delay(1, TimeUnit.DAYS))
    }

    @Throws(Exception::class)
    private fun processFight(webClient: WebClient, session: SessionResponse, requestProcessor: LWRequestProcessor, leek: Leek, count: Int) {
        for (i in 0 until count) {
            val opponents = requestProcessor.getLeekOpponents(webClient, session, leek.id)
                    ?.opponents
                    ?: emptyList()
            selectOpponent(leek, opponents)?.let {
                requestProcessor.startLeekFight(webClient, session, leek.id, it.id)
            }
        }
    }

    private fun selectOpponent(leek: Leek, opponents: List<Leek>): Leek? {
        return opponents.maxBy { getDist(leek, it) }
    }

    private fun getDist(l1: Leek, l2: Leek): Int {
        return abs(getValue(l1) - getValue(l2))
    }

    private fun getValue(leek: Leek): Int {
        return leek.level * leek.level * leek.talent
    }

}