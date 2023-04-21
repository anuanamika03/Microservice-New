package com.neom.assettech.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.neom.assettech.constants.AppConstants;

public class ResponseHandler {

	public static ResponseEntity<SuccessResponse> generateGetResponse(HttpStatus status, Object responseObj,
			HttpServletRequest request) {
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(AppConstants.SUCCESS_MESSAGE_FOR_GET,
				status.value(), responseObj, request.getRequestURI(), request.getMethod()), status);
	}

	public static ResponseEntity<SuccessResponse> generatePostResponse(HttpStatus status, HttpServletRequest request) {
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(AppConstants.SUCCESS_MESSAGE_FOR_INSERT,
				status.value(), request.getRequestURI(), request.getMethod()), status);
	}
	
	public static ResponseEntity<SuccessResponse> generatePostWithReturnResponse(HttpStatus status, Object responseObj, HttpServletRequest request) {
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(AppConstants.SUCCESS_MESSAGE_FOR_INSERT,
				status.value(), responseObj, request.getRequestURI(), request.getMethod()), status);
	}

	public static ResponseEntity<SuccessResponse> generatePatchResponse(HttpStatus status, HttpServletRequest request) {
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(AppConstants.SUCCESS_MESSAGE_FOR_UPDATE,
				status.value(), request.getRequestURI(), request.getMethod()), status);
	}
	
	public static ResponseEntity<SuccessResponse> generateDeleteResponse(HttpStatus status, HttpServletRequest request) {
		return new ResponseEntity<SuccessResponse>(new SuccessResponse(AppConstants.SUCCESS_MESSAGE_FOR_DELETE,
				status.value(), request.getRequestURI(), request.getMethod()), status);
	}
}
