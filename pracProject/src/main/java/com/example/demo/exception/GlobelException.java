package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobelException {
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetail> UserEceptionHandler(UserException ue,WebRequest req){
		
		ErrorDetail error = new ErrorDetail(ue.getMessage(),req.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<ErrorDetail>(error,HttpStatus.BAD_REQUEST);
	}
	
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> otherEceptionHandler(Exception ue,WebRequest req){
		
		ErrorDetail error = new ErrorDetail(ue.getMessage(),req.getDescription(false),LocalDateTime.now());
		return new ResponseEntity<ErrorDetail>(error,HttpStatus.BAD_REQUEST);
	}
}
