package com.leek.wars.bot.entities.responses;

import java.util.List;

import com.leek.wars.bot.entities.Leek;

public class OpponentLeeksResponse extends Response {

	private List<Leek> opponents;


	public List<Leek> getOpponents() {
		return opponents;
	}
	public void setOpponents(List<Leek> opponents) {
		this.opponents = opponents;
	}

}
