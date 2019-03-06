package com.leek.wars.client.util;

import fr.lewon.client.util.ICliEnum;

public enum UseMode implements ICliEnum {

	MENU("Run the client with a user interface"),
	AUTO("Run the client automatically based on actions you defined");
	
	private String desc;
	
	private UseMode(String desc) {
		this.desc = desc;
	}

	@Override
	public String getKey() {
		return name();
	}

	@Override
	public String getDescription() {
		return desc;
	}
	
}
