package com.example.demo.custom.exception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

//this is used for serviceImpl class error/exception handling.
@Component
@Data
@AllArgsConstructor
public class BusinessExceptionHandling extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
	
	public BusinessExceptionHandling() {
		
	}
}
