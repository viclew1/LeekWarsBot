package com.leek.wars.bot.entities.input

import com.fasterxml.jackson.annotation.JsonProperty

class FightInfosInput(
        @field:JsonProperty("leek_id") var leekId: Long = -1,
        @field:JsonProperty("target_id") var targetId: Long = -1
)