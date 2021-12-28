package com.gmail.amarciosm.controledepedidos.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(MyObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(
			MyObjectNotFoundException e, HttpServletRequest request){
		
		StandardError error = new StandardError(
				HttpStatus.NOT_FOUND.value(), 
				e.getMessage(), 
				System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(MyDataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolation(
			MyDataIntegrityViolationException e, HttpServletRequest request){
		
		StandardError error = new StandardError(
				HttpStatus.BAD_REQUEST.value(), 
				e.getMessage(), 
				System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> violation(
			MethodArgumentNotValidException e, HttpServletRequest request){
		
		ValidationError error = new ValidationError(
				HttpStatus.BAD_REQUEST.value(), 
				"Erro ao validar campos!", 
				System.currentTimeMillis());
		
		for(FieldError fe : e.getBindingResult().getFieldErrors()) {
			error.addError(fe.getField(), fe.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
