package com.leek.wars.bot.entities

class Potion {
    var id: Long? = null
    var template: Int? = null
    var quantity: Int? = null

    override fun toString(): String {
        return "Potion [id=$id, template=$template, quantity=$quantity]"
    }
}