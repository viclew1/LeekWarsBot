package com.leek.wars.bot.entities

import com.fasterxml.jackson.annotation.JsonProperty

class Fight {
    var id: Long? = null
    var date: Long? = null
    var type: Int? = null
    var context: Int? = null
    var status: Int? = null
    var winner: String? = null
    @JsonProperty("farmer_team")
    var farmerTeam: Int? = null
    var result: String? = null
    var farmer1: Long? = null
    var farmer2: Long? = null
    @JsonProperty("farmer1_name")
    var farmer1Name: String? = null
    @JsonProperty("farmer2_name")
    var farmer2Name: String? = null

    override fun toString(): String {
        return ("Fight [id=" + id + ", date=" + date + ", type=" + type + ", context=" + context + ", status=" + status
                + ", winner=" + winner + ", farmer1=" + farmer1 + ", farmer2=" + farmer2 + ", farmer1Name="
                + farmer1Name + ", farmer2Name=" + farmer2Name + "]")
    }
}