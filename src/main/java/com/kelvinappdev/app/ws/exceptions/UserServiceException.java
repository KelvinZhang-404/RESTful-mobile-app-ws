package com.kelvinappdev.app.ws.exceptions;

public class UserServiceException extends RuntimeException {
	
	private static final long serialVersionUID = -558129395424739151L;

	public UserServiceException(String message) {
		super(message);
	}
}
