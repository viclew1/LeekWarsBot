package com.leek.wars.bot.entities.input

import com.fasterxml.jackson.annotation.JsonProperty

class FightInfosInput(
        @JsonProperty("leek_id") var leekId: Long = -1,
        @JsonProperty("target_id") var targetId: Long = -1
)