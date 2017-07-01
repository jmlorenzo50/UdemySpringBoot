package com.udemy.backendninja.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
	
	private static final String ERROR_500_VIEW = "error/500";

	@ExceptionHandler(Exception.class)
	public String showInternalServerError() {
		return ERROR_500_VIEW;
	}

	
}
