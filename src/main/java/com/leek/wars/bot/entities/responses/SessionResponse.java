package com.leek.wars.bot.entities.responses;

import org.apache.http.Header;

import com.leek.wars.bot.entities.Farmer;

public class SessionResponse extends Response {

	private Farmer farmer;
	private Header cookie;


	public Farmer getFarmer() {
		return farmer;
	}
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
	public Header getCookie() {
		return cookie;
	}
	public void setCookie(Header cookie) {
		this.cookie = cookie;
	}
}
