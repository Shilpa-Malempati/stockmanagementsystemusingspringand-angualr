package com.jfsfeb.stockmanagement.controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jfsfeb.stockmanagement.dto.StockResponse;
import com.jfsfeb.stockmanagement.exception.ValidationException;

@RestControllerAdvice 
public class StockControllerAdvice {
	@ExceptionHandler(ValidationException.class)
	public StockResponse handleStockException(ValidationException e) {
		StockResponse stockResponse = new StockResponse();
		stockResponse.setStatusCode(501);
		stockResponse.setMessage("Exception");
		stockResponse.setDescription(e.getMessage());
		return stockResponse;
	}
}
