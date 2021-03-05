package com.jfsfeb.stockmanagement.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jfsfeb.stockmanagement.dto.CompanyResponse;
import com.jfsfeb.stockmanagement.exception.ValidationException;
@RestControllerAdvice 
public class CompanyControllerAdvice {
	@ExceptionHandler(ValidationException.class)
	public CompanyResponse handleCustomerException(ValidationException e) {
		CompanyResponse companyResponse = new CompanyResponse();
		companyResponse.setStatusCode(501);
		companyResponse.setMessage("Exception");
		companyResponse.setDescription(e.getMessage());
		return companyResponse;
	}
}
