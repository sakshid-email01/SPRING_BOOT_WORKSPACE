package com.example.demo.custom.exception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

//this is used for repo class error/exception handling 
//if there is additional code in it
@Component
@Data
@AllArgsConstructor
public class RepoExceptionHandling {
	
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;

	public RepoExceptionHandling() {

	}
}
