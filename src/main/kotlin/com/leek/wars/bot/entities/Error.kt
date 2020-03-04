package com.leek.wars.bot.entities

enum class Error(var errorStr: String) {
    ALREADY_REGISTERED("already_registered");

    companion object {
        fun getByErrorStr(errorStr: String): Error? {
            for (e in values()) {
                if (e.errorStr == errorStr) {
                    return e
                }
            }
            return null
        }
    }

}