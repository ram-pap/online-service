package com.springboot.example.exception;

public class OrderNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3640988722369668124L;
	

	public OrderNotFoundException() {
		super();
	}

	public OrderNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OrderNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderNotFoundException(String message) {
		super(message);
	}

	public OrderNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
