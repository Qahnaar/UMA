package com.uma.controller.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	private final static Logger LOG = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	@ResponseBody
	public String handleException(Exception exception) {
		LOG.debug("Exception with message -> " + exception.getMessage() + " has been picked");
		return "CONFLICT";
	}
}
