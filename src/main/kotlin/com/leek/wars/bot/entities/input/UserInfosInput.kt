package com.leek.wars.bot.entities.input

import com.fasterxml.jackson.annotation.JsonProperty

class UserInfosInput(
        @JsonProperty var login: String = "",
        @JsonProperty var password: String = "",
        @JsonProperty("keep_connected") var keepConnected: Boolean = false
)