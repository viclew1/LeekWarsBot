package com.leek.wars.client.util.exceptions;

import com.leek.wars.client.util.UseMode;

public class WrongUseModeException extends LWException {

	private static final long serialVersionUID = -5659535491623101072L;

	public WrongUseModeException(String useModeEntered) {
		super(generateExceptionMessage(useModeEntered));
	}
	
	private static String generateExceptionMessage(String useModeEntered) {
		String msg = "Wrong use mode (" + useModeEntered + ")\n";
		msg += "Available use modes :\n";
		for (UseMode um : UseMode.values()) {
			msg += "  - " + um.name() + " : " + um.getDescription() + "\n";
		}
		return msg;
	}

}
