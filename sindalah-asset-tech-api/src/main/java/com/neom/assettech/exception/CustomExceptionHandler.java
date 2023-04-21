package com.neom.assettech.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<String, String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.put(error.getObjectName(), error.getDefaultMessage());
		}
		ErrorDetails errorDetails = new ErrorDetails("METHOD_ARGUMENT_NOT_VALID", request.getDescription(false), status,
				errors);
		ex.printStackTrace();
		return new ResponseEntity<>(errorDetails, status);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails("INTERNAL_SERVER_ERROR", request.getDescription(false),
				HttpStatus.NO_CONTENT, ex.getMessage());
		ex.printStackTrace();
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<ErrorDetails> handleFormExceptions(CustomException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails("METHOD_ARGUMENT_NOT_VALID", request.getDescription(false),
				HttpStatus.BAD_REQUEST, ex.getErrors());
		ex.printStackTrace();
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

}
