package com.leek.wars.client.util.exceptions;

import java.util.Iterator;
import java.util.List;

public class MissingParameterException extends LWException {

	private static final long serialVersionUID = -3221949866357848023L;

	public MissingParameterException(List<String> missingParams) {
		super(generateMessage(missingParams));
	}

	private static String generateMessage(List<String> missingParams) {
		String msg = "[";
		Iterator<String> it = missingParams.iterator();
		while (it.hasNext()) {
			String param = it.next();
			msg += param;
			if (it.hasNext()) {
				msg += ", ";
			}
		}
		msg += "]";
		return msg;
	}

	
	
}
