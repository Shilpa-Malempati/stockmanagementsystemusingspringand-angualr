package com.jfsfeb.stockmanagement.controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jfsfeb.stockmanagement.dto.UserResponse;
import com.jfsfeb.stockmanagement.exception.ValidationException;

@RestControllerAdvice 
public class UserControllerAdvice {
	@ExceptionHandler(ValidationException.class)
	public UserResponse handleUserException(ValidationException e) {
		UserResponse userResponse = new UserResponse();
		userResponse.setStatusCode(501);
		userResponse.setMessage("Exception");
		userResponse.setDescription(e.getMessage());
		return userResponse;
	}
}
