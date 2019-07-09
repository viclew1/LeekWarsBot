package com.leek.wars.bot.entities.input;

import fr.lewon.bot.http.body.urlencoded.FUEMember;

public class LeekInfosInput {

	@FUEMember("leek_id")
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
