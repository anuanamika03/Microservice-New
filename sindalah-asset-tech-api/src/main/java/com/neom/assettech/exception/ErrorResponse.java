package com.neom.assettech.exception;

import java.util.Date;
import java.util.List;

public class ErrorResponse {

	private String date;
	private String path;
	private List<ErrorMessage> errors;
	
	
	public ErrorResponse(String path, List<ErrorMessage> errors) {
		super();
		this.date = new Date().toString();
		this.path = path;
		this.errors = errors;
	}

	public String getDate() {
		return date;
	}

	public String getPath() {
		return path;
	}

	public List<ErrorMessage> getErrors() {
		return errors;
	}
	
}
