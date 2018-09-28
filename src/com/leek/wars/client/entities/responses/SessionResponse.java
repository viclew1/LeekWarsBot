package com.leek.wars.client.entities.responses;

import com.leek.wars.client.entities.Farmer;

public class SessionResponse extends Response {

	private Farmer farmer;
	private String token;
	
	
	public Farmer getFarmer() {
		return farmer;
	}
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	@Override
	public String toString() {
		return "Session [farmer=" + farmer + ", token=" + token + "]";
	}
}
