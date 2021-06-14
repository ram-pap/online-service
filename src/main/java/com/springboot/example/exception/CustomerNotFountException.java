package com.springboot.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomerNotFountException extends Throwable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CustomerNotFountException() {
		super();
	}


	public CustomerNotFountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}


	public CustomerNotFountException(String message, Throwable cause) {
		super(message, cause);
	}


	public CustomerNotFountException(Throwable cause) {
		super(cause);
	}


	public CustomerNotFountException(String message) {
		super(message);
	}
	

}
