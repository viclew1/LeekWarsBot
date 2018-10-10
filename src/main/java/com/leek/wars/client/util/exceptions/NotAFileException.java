package com.leek.wars.client.util.exceptions;

public class NotAFileException extends LWException {

	private static final long serialVersionUID = -1476950281480467657L;

	public NotAFileException(String key, String path) {
		super(key + " [" + path + "] is not a file");
	}

}
