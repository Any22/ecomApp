package com.example.ecommapp.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ecommapp.util.AppConstants;





@RestControllerAdvice
public class GlobalExceptionHandler {
	@Autowired 
	private Environment environment;
	
	@ExceptionHandler (Exception.class)
	public ResponseEntity<ErrorMessage> generalExceptionHandler(Exception ex){
		
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(environment.getProperty(AppConstants.GENERAL_EXCEPTION.toString()));
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler (NotFoundException.class)
	public ResponseEntity<ErrorMessage> notFoundExceptionHandler(NotFoundException ex){
		
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}
}
