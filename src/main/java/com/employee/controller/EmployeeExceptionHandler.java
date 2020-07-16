package com.employee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.employee.datamodel.DuplicateDataException;
import com.employee.datamodel.ResourceNotFoundException;

@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value=ResourceNotFoundException.class)
	protected ResponseEntity<ResourceNotFoundException> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
		return ResponseEntity.status(404).body(resourceNotFoundException);	
	}
	
	@ExceptionHandler(value=DuplicateDataException.class)
	protected ResponseEntity<DuplicateDataException> handleDuplicateDataException(DuplicateDataException duplicateDataException){
		return ResponseEntity.status(409).body(duplicateDataException);	
	}
	
}
