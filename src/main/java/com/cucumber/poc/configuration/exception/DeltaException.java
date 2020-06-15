package com.cucumber.poc.configuration.exception;

public class DeltaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DeltaException(String message, Throwable ex) {
		super(message, ex);
	}

}
