package com.springboot.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserNotFountException extends Throwable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserNotFountException() {
		super();
	}


	public UserNotFountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}


	public UserNotFountException(String message, Throwable cause) {
		super(message, cause);
	}


	public UserNotFountException(Throwable cause) {
		super(cause);
	}


	public UserNotFountException(String message) {
		super(message);
	}
	

}
