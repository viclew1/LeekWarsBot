package com.leek.wars.bot

import com.leek.wars.bot.operations.DefaultLeekWarsTask
import com.leek.wars.bot.util.LWSessionManager
import fr.lewon.bot.runner.AbstractBotBuilder
import fr.lewon.bot.runner.Bot
import fr.lewon.bot.runner.bot.props.BotPropertyDescriptor
import fr.lewon.bot.runner.bot.props.BotPropertyStore
import fr.lewon.bot.runner.bot.props.BotPropertyType
import fr.lewon.bot.runner.bot.task.BotTask
import fr.lewon.bot.runner.session.AbstractSessionManager
import org.springframework.web.reactive.function.client.WebClient

class LWBotBuilder : AbstractBotBuilder(
        expectedLoginProperties = listOf(
                BotPropertyDescriptor("Password", BotPropertyType.STRING, null, "Your account password", isNeeded = true, isNullable = false)
        ),
        botPropertyDescriptors = emptyList(),
        botOperations = emptyList()) {

    override fun buildSessionManager(login: String, loginPropertyStore: BotPropertyStore): AbstractSessionManager {
        return LWSessionManager(login, loginPropertyStore,
                WebClient.builder()
                        .baseUrl("https://leekwars.com/")
                        .defaultHeader("Accept", "*/*")
                        .defaultHeader("Accept-Language", "fr-FR,fr;q=0.9,en-GB;q=0.8,en;q=0.7,en-US;q=0.6")
                        .defaultHeader("Connection", "keep-alive")
                        .defaultHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                        .defaultHeader("Host", "leekwars.com")
                        .defaultHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.103 Safari/537.36")
                        .defaultHeader("Authorization", "Bearer $"))
    }

    override fun getInitialTasks(bot: Bot): List<BotTask> {
        return listOf(
                DefaultLeekWarsTask(bot)
        )
    }
}