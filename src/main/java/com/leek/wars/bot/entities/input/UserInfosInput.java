package com.leek.wars.bot.entities.input;

import com.leek.wars.bot.util.BodyMember;

public class UserInfosInput {

	@BodyMember
	private String login;

	@BodyMember
	private String password;

	@BodyMember("keep_connected")
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
