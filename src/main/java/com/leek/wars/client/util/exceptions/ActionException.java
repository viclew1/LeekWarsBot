package com.leek.wars.client.util.exceptions;

public class ActionException extends LWException {

	private static final long serialVersionUID = -2699904406080200457L;

	public ActionException(Exception cause) {
		super(cause.getMessage());
	}
	
	public ActionException(String message) {
		super(message);
	}

}
