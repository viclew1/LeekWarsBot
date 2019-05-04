package com.leek.wars.bot.entities.responses;

import com.leek.wars.bot.entities.Tournament;

public class LeekInfosResponse extends Response {

	private Long id;
	private String name;
	private Tournament tournament;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Tournament getTournament() {
		return tournament;
	}
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

}
