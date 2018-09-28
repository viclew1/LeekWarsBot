package com.leek.wars.client.entities.responses;

import com.leek.wars.client.entities.Error;

public class Response {

	private Boolean success;
	private Error error;

	public Boolean isSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Error getError() {
		return error;
	}
	public void setError(Error error) {
		this.error = error;
	}
	public void setError(String error) {
		this.error = Error.getByErrorStr(error);
	}
	
	
	@Override
	public String toString() {
		return "Response [success=" + success + ", error=" + error + "]";
	}
}