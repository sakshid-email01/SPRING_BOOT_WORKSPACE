package com.example.postgresql.crud.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.postgresql.crud.custom.exception.EmptyInputException;

@ControllerAdvice
// global exception handling requires common classes like emptyinputexceptionhandling so 
// that such common errors thrown via such classes from any class in the application
// can be handled globally by the globalexceptionhandlingclasses

public class GlobalExceptionHandlerClass {
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException e){
		// custom msg and status for all places throwing EmptyInputException error
		// so that each error calling place can send unique code and msg
		//return new ResponseEntity<String>(e.getErrCode()+e.getErrMsg(),null, 601);
		
		// common msg and status for all places throwing EmptyInputException error
		return new ResponseEntity<String>("empty input field",HttpStatus.BAD_REQUEST);
	}

}
