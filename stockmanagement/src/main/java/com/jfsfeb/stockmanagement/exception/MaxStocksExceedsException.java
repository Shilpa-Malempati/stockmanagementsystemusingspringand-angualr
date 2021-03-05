package com.jfsfeb.stockmanagement.exception;

public class MaxStocksExceedsException extends RuntimeException {
	String message;

	public MaxStocksExceedsException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
