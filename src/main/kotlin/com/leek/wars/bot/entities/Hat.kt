package com.leek.wars.bot.entities

import com.fasterxml.jackson.annotation.JsonProperty

class Hat {
    var id: Long? = null
    var template: Int? = null
    var level: Int? = null
    var name: String? = null
    @JsonProperty("hat_template")
    var hatTemplate: Int? = null

    override fun toString(): String {
        return ("Hat [id=" + id + ", template=" + template + ", level=" + level + ", name=" + name + ", hatTemplate="
                + hatTemplate + "]")
    }
}