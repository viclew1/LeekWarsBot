package com.leek.wars.bot.entities

class Weapon {
    var id: Long? = null
    var template: Int? = null

    override fun toString(): String {
        return "Weapon [id=$id, template=$template]"
    }
}