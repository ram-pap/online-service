package com.springboot.example.exception;

import java.util.Date;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomerNotFountException.class)
	protected ResponseEntity<Object> handleCustomerEntityNotFound(CustomerNotFountException ex) {
		Error apiError = new Error();
		apiError.setError(HttpStatus.NOT_FOUND.name());
		apiError.setStatus(HttpStatus.NOT_FOUND.value());
		apiError.setMessage(ex.getMessage());
		apiError.setTimeStamp(new Date());
		return new ResponseEntity<Object>(apiError, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(OrderNotFoundException.class)
	protected ResponseEntity<Object> handleOrderEntityNotFound(OrderNotFoundException ex) {
		Error apiError = new Error();
		apiError.setError(HttpStatus.NOT_FOUND.name());
		apiError.setStatus(HttpStatus.NOT_FOUND.value());
		apiError.setMessage(ex.getMessage());
		apiError.setTimeStamp(new Date());
		return new ResponseEntity<Object>(apiError, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RuntimeException.class)
	protected ResponseEntity<Object> handleGlobalException(CustomerNotFountException ex) {
		Error apiError = new Error();
		apiError.setError(HttpStatus.BAD_REQUEST.name());
		apiError.setStatus(HttpStatus.BAD_REQUEST.value());
		apiError.setMessage(ex.getMessage());
		apiError.setTimeStamp(new Date());
		return new ResponseEntity<Object>(apiError, HttpStatus.BAD_REQUEST);
	}

}
