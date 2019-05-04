package com.leek.wars.bot.entities;

public enum Error {
	
	ALREADY_REGISTERED("already_registered");
	
	private String errorStr;
	
	private Error(String errorStr) {
		this.errorStr = errorStr;
	}

	public static Error getByErrorStr(String errorStr) {
		for (Error e : values()) {
			if (e.getErrorStr().equals(errorStr)) {
				return e;
			}
		}
		return null;
	}

	public String getErrorStr() {
		return errorStr;
	}
	public void setErrorStr(String errorStr) {
		this.errorStr = errorStr;
	}
}
