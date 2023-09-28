package com.employee.employee.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BindExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(org.springframework.validation.BindException.class)
    public ResponseEntity<?> handleBindException(org.springframework.validation.BindException ex) {
	Map<String, String> errors = new HashMap<>();
	ex.getBindingResult().getAllErrors().forEach((error) -> {
	    String fieldName = ((FieldError) error).getField();
	    String errorMessage = error.getDefaultMessage();
	    errors.put(fieldName, errorMessage);
	});
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}