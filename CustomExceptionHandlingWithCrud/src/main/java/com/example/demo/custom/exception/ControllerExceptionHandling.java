package com.example.demo.custom.exception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Component
@AllArgsConstructor
//this is used for controller class error/exception handling
public class ControllerExceptionHandling extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
	
	public ControllerExceptionHandling() {
		
	}

}
