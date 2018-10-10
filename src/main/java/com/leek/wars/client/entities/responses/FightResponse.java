package com.leek.wars.client.entities.responses;

import com.leek.wars.client.entities.Fight;

public class FightResponse extends Response {

	private Fight fight;

	
	public Fight getFight() {
		return fight;
	}
	public void setFight(Fight fight) {
		this.fight = fight;
	}
	
}
