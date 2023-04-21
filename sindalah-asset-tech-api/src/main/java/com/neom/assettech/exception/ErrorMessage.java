package com.neom.assettech.exception;

public class ErrorMessage {

	private String error_code;
	private String error_description;
	
	public ErrorMessage(String error_code, String error_description) {
		super();
		this.error_code = error_code;
		this.error_description = error_description;
	}

	public String getError_code() {
		return error_code;
	}

	public String getError_description() {
		return error_description;
	}
	
}
