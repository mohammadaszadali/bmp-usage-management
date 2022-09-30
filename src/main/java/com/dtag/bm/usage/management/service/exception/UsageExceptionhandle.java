package com.dtag.bm.usage.management.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class UsageExceptionhandle extends ResponseEntityExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UsageMandateFieldsException.class)
	public ResponseEntity<String> handlemandateFiledsException(Exception ex, WebRequest request) {

		String errorMessge = ex.getMessage();

		return new ResponseEntity<String>(errorMessge, HttpStatus.BAD_REQUEST);
	}
}
