package com.leek.wars.bot.entities.input;

import com.leek.wars.bot.util.BodyMember;

public class LeekInfosInput {

	@BodyMember("leek_id")
	private Long leekId;

	public LeekInfosInput() {
	}

	public LeekInfosInput(Long leekId) {
		this.leekId = leekId;
	}

	public Long getLeekId() {
		return leekId;
	}

	public void setLeekId(Long leekId) {
		this.leekId = leekId;
	}

}
