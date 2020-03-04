package com.leek.wars.bot.entities

class Leek {
    var id: Long = -1
    var name: String = ""
    var color: String? = null
    var capital: Int? = null
    var level: Int = 0
    var talent: Int = 0
    var skin: Int? = null
    var hat: Int? = null

    override fun toString(): String {
        return ("Leek [id=" + id + ", name=" + name + ", color=" + color + ", capital=" + capital + ", level=" + level
                + ", talent=" + talent + ", skin=" + skin + ", hat=" + hat + "]")
    }

    fun toSimpleString(): String {
        return "$name ($level - $talent)"
    }
}