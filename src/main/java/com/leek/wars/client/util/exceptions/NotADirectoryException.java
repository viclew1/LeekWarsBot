package com.leek.wars.client.util.exceptions;

public class NotADirectoryException extends LWException {

	private static final long serialVersionUID = 166739832110685862L;

	public NotADirectoryException(String key, String path) {
		super(key + " [" + path + "] is not a directory");
	}

}
