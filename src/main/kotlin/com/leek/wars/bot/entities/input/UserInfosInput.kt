package com.leek.wars.bot.entities.input

import com.fasterxml.jackson.annotation.JsonProperty

class UserInfosInput(
        @field:JsonProperty var login: String = "",
        @field:JsonProperty var password: String = "",
        @field:JsonProperty("keep_connected") var keepConnected: Boolean = false
)