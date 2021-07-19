package com.springboot.example.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class Error {
	
	private String message;
	private Throwable error;
	private HttpStatus status;
	private Date timeStamp;
	
	public Error() {
		
	}
	public String getMessage() {
		return message;
	}
	public Error setMessage(String message) {
		this.message = message;
		return this;
	}
	public Throwable getError() {
		return error;
	}
	@Override
	public String toString() {
		return "Error [message=" + message + ", error=" + error + ", status=" + status + ", timeStamp=" + timeStamp
				+ "]";
	}
	public Error setError(Throwable throwable) {
		this.error = throwable;
		return this;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public Error setStatus(HttpStatus conflict) {
		this.status = conflict;
		return this;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public Error setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
		return this;
	}
	
	

}
