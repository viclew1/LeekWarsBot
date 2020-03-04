package com.leek.wars.bot.entities

class Chip {
    var id: Long? = null
    var template: Int? = null

    override fun toString(): String {
        return "Chip [id=$id, template=$template]"
    }
}