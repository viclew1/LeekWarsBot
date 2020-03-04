package com.leek.wars.bot.entities

import com.fasterxml.jackson.annotation.JsonProperty

class Team {
    var id: Long? = null
    var name: String? = null
    var level: Int? = null
    @JsonProperty("emblem_changed")
    var emblemChanged: Int? = null

    override fun toString(): String {
        return "Team [id=$id, name=$name, level=$level, emblemChanged=$emblemChanged]"
    }
}