package com.ashok.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{
    
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> userNotFoundHandler(UserNotFoundException ex){
		ErrorResponse res = new ErrorResponse("Problem in fetching user",ex.getMessage());
		return new ResponseEntity<ErrorResponse>(res,HttpStatus.NOT_FOUND);
				   
	}
}
