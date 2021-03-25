package com.cg.onlineshopping.exception;


import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(CustomerNotFoundException exception, WebRequest webRequest)
	{
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(ProductNotFoundException exception, WebRequest webRequest)
	{
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(AddressNotFoundException exception, WebRequest webRequest)
	{
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(OrderNotFoundException exception, WebRequest webRequest)
	{
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(UserNotFoundException exception, WebRequest webRequest)
	{
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}
	@ExceptionHandler(CategoryNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(CategoryNotFoundException exception, WebRequest webRequest)
	{
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}
	@ExceptionHandler(CartNotFoundException.class)
	public ResponseEntity<Object> handleExceptions(CartNotFoundException exception, WebRequest webRequest)
	{
		logger.error(exception.getMessage());
		ExceptionResponse response = new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		return entity;
	}
	@Override
	   protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	            HttpHeaders headers, HttpStatus status, WebRequest request) {
	        logger.error(ex.getMessage());
	         Map<String, String> errors = new HashMap<>();
	            ex.getBindingResult().getAllErrors().forEach((error) -> {
	                String fieldName = ((FieldError) error).getField();
	                String errorMessage = error.getDefaultMessage();
	                errors.put(fieldName, errorMessage);
	               
	            });
	            ResponseEntity<Object> entity = new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	            return entity;
	    }
}
