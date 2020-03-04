package com.leek.wars.bot.entities

class TournamentHistoryItem {
    var id: Long? = null
    var date: Long? = null

    override fun toString(): String {
        return "TournamentHistoryItem [id=$id, date=$date]"
    }
}