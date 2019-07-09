package com.leek.wars.bot.entities.input;

import fr.lewon.bot.http.body.urlencoded.FUEMember;

public class UserInfosInput {

	@FUEMember
	private String login;

	@FUEMember
	private String password;

	@FUEMember("keep_connected")
	private Boolean keepConnected = false;

	public UserInfosInput() {
	}

	public UserInfosInput(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getKeepConnected() {
		return keepConnected;
	}

	public void setKeepConnected(Boolean keepConnected) {
		this.keepConnected = keepConnected;
	}

}
