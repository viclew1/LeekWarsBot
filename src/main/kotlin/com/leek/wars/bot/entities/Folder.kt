package com.leek.wars.bot.entities

class Folder {
    var id: Long? = null
    var name: String? = null
    var folder: Long? = null

    override fun toString(): String {
        return "Folder [id=$id, name=$name, folder=$folder]"
    }
}