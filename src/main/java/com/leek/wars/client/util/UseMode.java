package com.leek.wars.client.util;

public enum UseMode {

	COMMAND_LINE("Runs the application in command line"), 
	GRAPHIC_INTERFACE("Runs the application in graphic interface"); 
	
	public static final UseMode DEFAULT_USE_MODE = COMMAND_LINE;

	private final String description;
	
	private UseMode(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
}
