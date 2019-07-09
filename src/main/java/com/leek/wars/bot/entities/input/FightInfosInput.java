package com.leek.wars.bot.entities.input;

import fr.lewon.bot.http.body.urlencoded.FUEMember;

public class FightInfosInput {

	@FUEMember("leek_id")
	private Long leekId;

	@FUEMember("target_id")
	private Long targetId;


	public FightInfosInput() {
	}

	public FightInfosInput(Long leekId, Long targetId) {
		this.leekId = leekId;
		this.targetId = targetId;
	}

	public Long getLeekId() {
		return leekId;
	}

	public void setLeekId(Long leekId) {
		this.leekId = leekId;
	}

	public Long getTargetId() {
		return targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

}
