package com.leek.wars.bot.entities.responses

import com.leek.wars.bot.entities.Error

open class Response {
    var isSuccess: Boolean? = null
    var error: Error? = null

    fun setError(error: String) {
        this.error = Error.Companion.getByErrorStr(error)
    }

    override fun toString(): String {
        return "Response [success=" + isSuccess + ", error=" + error + "]"
    }
}