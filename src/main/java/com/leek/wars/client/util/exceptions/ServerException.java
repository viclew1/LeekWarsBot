package com.leek.wars.client.util.exceptions;

public class ServerException extends LWException {

	private static final long serialVersionUID = -7970506899840821801L;

	public ServerException(String url, int code, String message) {
		super(generateExceptionMessage(url, code, message));
	}
	
	private static String generateExceptionMessage(String url, int code, String message) {
		String msg = "";
		msg += "URL     : " + url + "\n";
		msg += "CODE    : " + code + "\n";
		msg += "MESSAGE : " + message;
		return msg;
	}

}