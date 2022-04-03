package com.kelvinappdev.app.ws.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kelvinappdev.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyExceptioin(Exception ex, WebRequest request) {
		
		String errorDesc = ex.getLocalizedMessage();
		if(errorDesc == null) errorDesc = ex.toString();
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDesc);
		
		return new ResponseEntity<>(
				errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity<Object> handleNullPointerExceptioin(NullPointerException ex, WebRequest request) {
		
		String errorDesc = ex.getLocalizedMessage();
		if(errorDesc == null) errorDesc = ex.toString();
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDesc);
		
		return new ResponseEntity<>(
				errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {UserServiceException.class})
	public ResponseEntity<Object> handleUserServiceExceptioin(UserServiceException ex, WebRequest request) {
		
		String errorDesc = ex.getLocalizedMessage();
		if(errorDesc == null) errorDesc = ex.toString();
		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDesc);
		
		return new ResponseEntity<>(
				errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
