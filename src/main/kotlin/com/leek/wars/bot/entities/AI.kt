package com.leek.wars.bot.entities

class AI {
    var id: Long? = null
    var name: String? = null
    var level: Int? = null
    var valid: Boolean? = null
    var folder: Long? = null
    var v2: Int? = null
    var code: String? = null

    override fun toString(): String {
        return "AI [id=$id, name=$name, level=$level]"
    }
}