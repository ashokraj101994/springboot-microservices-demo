package com.ashok.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

@RestControllerAdvice
public class CustomExceptionHandler {
	//
   @ExceptionHandler(UserNotFoundException.class)
   public ResponseEntity<ErrorResponse> userNotFoundHandler(UserNotFoundException ex){
	   ErrorResponse erRes = new ErrorResponse("Problem is fetching User",ex.getMessage());
	   return new ResponseEntity<ErrorResponse>(erRes,HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(HttpServerErrorException.class)
   public ResponseEntity<ErrorResponse> userServiceHandler(HttpServerErrorException ex){
	   ErrorResponse erRes = new ErrorResponse("Problem is Accessing UserService",ex.getMessage());
	   return new ResponseEntity<ErrorResponse>(erRes,HttpStatus.INTERNAL_SERVER_ERROR);
   }

}
