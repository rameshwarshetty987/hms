package com.hms.clinic.suyesha.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value=PatientIDException.class)
	public ResponseEntity<Object> exception() {
		return new ResponseEntity<Object>("Patient Id is not Present", HttpStatus.CHECKPOINT);
	}
 }
