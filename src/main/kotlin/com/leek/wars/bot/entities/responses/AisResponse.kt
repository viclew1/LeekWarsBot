package com.leek.wars.bot.entities.responses

import com.leek.wars.bot.entities.AI
import com.leek.wars.bot.entities.Folder

class AisResponse : Response(), Iterable<AI?> {
    private var ais: MutableList<AI>? = null
    var folders: List<Folder>? = null
    fun getAis(): List<AI>? {
        return ais
    }

    fun setAis(ais: MutableList<AI>?) {
        this.ais = ais
    }

    override fun iterator(): MutableIterator<AI> {
        return ais!!.iterator()
    }
}