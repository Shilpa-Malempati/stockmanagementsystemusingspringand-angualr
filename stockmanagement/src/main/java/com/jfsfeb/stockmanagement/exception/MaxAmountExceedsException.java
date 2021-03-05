package com.jfsfeb.stockmanagement.exception;

public class MaxAmountExceedsException extends RuntimeException {

	String message;

	public MaxAmountExceedsException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
