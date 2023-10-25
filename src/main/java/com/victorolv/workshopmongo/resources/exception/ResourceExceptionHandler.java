package com.victorolv.workshopmongo.resources.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.victorolv.workshopmongo.services.exception.DatabaseException;
import com.victorolv.workshopmongo.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity <StandardError> resourceNotFound(ObjectNotFoundException e,HttpServletRequest request){
		String error = "object not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError er = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(er);
	}
	
	
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity <StandardError> database(DatabaseException e,HttpServletRequest request){
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError er = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(er);
	}
}

