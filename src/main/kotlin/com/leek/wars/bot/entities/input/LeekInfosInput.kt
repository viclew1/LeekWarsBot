package com.leek.wars.bot.entities.input

import com.fasterxml.jackson.annotation.JsonProperty

class LeekInfosInput(
        @field:JsonProperty("leek_id") var leekId: Long = -1
)