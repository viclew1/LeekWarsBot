package com.leek.wars.client.entities;

public class TournamentHistoryItem {

	private Long id;
	private Long date;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	
	
	@Override
	public String toString() {
		return "TournamentHistoryItem [id=" + id + ", date=" + date + "]";
	}
}
