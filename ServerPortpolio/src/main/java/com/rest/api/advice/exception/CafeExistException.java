package com.rest.api.advice.exception;

public class CafeExistException extends RuntimeException{

	public CafeExistException(String msg, Throwable t) {
		super(msg, t);
	}
	
	public CafeExistException(String msg) {
		super(msg);
	}
	
	public CafeExistException() {
		super();
	}
}
