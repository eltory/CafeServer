package com.rest.api.advice.exception;

public class CafeNotFoundException extends RuntimeException{
	
	public CafeNotFoundException(String msg, Throwable t) {
		super(msg, t);
	}
	
	public CafeNotFoundException(String msg) {
		super(msg);
	}
	
	public CafeNotFoundException() {
		super();
	}
}
