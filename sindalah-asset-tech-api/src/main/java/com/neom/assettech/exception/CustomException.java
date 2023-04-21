package com.neom.assettech.exception;

import java.util.Map;

public class CustomException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5941509165435515627L;
	private Map<String, String> errors;
	public CustomException(Map<String, String> errors) {
		super();
		this.errors = errors;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

}
