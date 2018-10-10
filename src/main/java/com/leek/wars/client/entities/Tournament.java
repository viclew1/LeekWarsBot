package com.leek.wars.client.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Tournament {

	private Boolean registered;
	//TODO current
	@JsonIgnore
	private Object current;

	
	public Boolean getRegistered() {
		return registered;
	}
	public void setRegistered(Boolean registered) {
		this.registered = registered;
	}
	public Object getCurrent() {
		return current;
	}
	public void setCurrent(Object current) {
		this.current = current;
	}
	
	
	@Override
	public String toString() {
		return "Tournament [registered=" + registered + ", current=" + current + "]";
	}
}
