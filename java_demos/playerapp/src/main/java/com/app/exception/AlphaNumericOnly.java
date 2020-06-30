package com.app.exception;

public class AlphaNumericOnly extends RuntimeException {
	public AlphaNumericOnly() {
		super();
	}

	public AlphaNumericOnly(String message) {
		super(message);
	}
}
