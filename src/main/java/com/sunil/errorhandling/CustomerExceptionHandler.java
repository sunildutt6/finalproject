package com.sunil.errorhandling;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> customerNotFoundHandler(CustomerNotFoundException cs, HttpServletRequest req){
		CustomerErrorResponse error = new CustomerErrorResponse(ZonedDateTime.now(), HttpStatus.NOT_FOUND.value(), req.getRequestURI(), cs.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> genricHandler(Exception ex, HttpServletRequest req){
		CustomerErrorResponse errorResponse = new CustomerErrorResponse(ZonedDateTime.now(), HttpStatus.BAD_REQUEST.value(), req.getRequestURI(), ex.getMessage() );
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
