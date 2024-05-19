package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.custom.exception.BusinessExceptionHandling;
import com.example.demo.custom.exception.ControllerExceptionHandling;
import com.example.demo.model.Model;
import com.example.demo.service.ServiceInterface;

@RestController
@RequestMapping("/crud")
public class Controller {

	@Autowired
	ServiceInterface service;

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Model model){
		try {
			Model savedModel = service.create(model);
			return new ResponseEntity<String>("Following data added "+savedModel, HttpStatus.CREATED);	
		}
		catch(BusinessExceptionHandling e) {
			ControllerExceptionHandling ce = 
					new ControllerExceptionHandling(e.getErrorCode(), e.getErrorMessage());
			return new ResponseEntity<ControllerExceptionHandling>(ce, HttpStatus.BAD_REQUEST);
		}
        catch(Exception e) {
        	ControllerExceptionHandling ce = 
					new ControllerExceptionHandling("612", "general error in controller"+e.getMessage());
        	return new ResponseEntity<ControllerExceptionHandling>(ce, HttpStatus.BAD_REQUEST);
		}
		
	}


}
