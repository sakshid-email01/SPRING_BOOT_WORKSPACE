package com.example.postgresql.crud.custom.exception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@Data
@AllArgsConstructor
public class EmptyInputException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errCode;
	private String errMsg;
	
    public EmptyInputException() {
    	
    }
}
