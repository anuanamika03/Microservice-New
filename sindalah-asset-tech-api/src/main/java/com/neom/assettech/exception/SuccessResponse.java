package com.neom.assettech.exception;

public class SuccessResponse {

	private String message;
	private String path;
	private String method;
	private Integer status;
	public Object data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public SuccessResponse() {}
	public SuccessResponse(String message, Integer status, Object data, String path, String method) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
		this.path = path;
		this.method = method;
	}
	public SuccessResponse(String message, Integer status, String path, String method) {
		super();
		this.message = message;
		this.status = status;
		this.path = path;
		this.method = method;
	}
	
}
