package com.rest.api.advice.exception;

public class AuthEntryPointException extends RuntimeException{

	public AuthEntryPointException(String msg, Throwable t) {
		super(msg, t);
	}
	
	public AuthEntryPointException(String msg) {
		super(msg);
	}
	
	public AuthEntryPointException() {
		super();
	}
}
