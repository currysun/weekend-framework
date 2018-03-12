package com.test.util;

public class DefinedException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DefinedException() {
		super();
	}

	public DefinedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DefinedException(String message, Throwable cause) {
		super(message, cause);
	}

	public DefinedException(String message) {
		super(message);
	}

	public DefinedException(Throwable cause) {
		super(cause);
	}
	
	
	
}
