package com.leek.wars.bot.entities.responses

import com.leek.wars.bot.entities.Farmer

class SessionResponse : Response() {
    var farmer: Farmer? = null
    var cookieName: String = ""
    var cookieValue: String = ""

}