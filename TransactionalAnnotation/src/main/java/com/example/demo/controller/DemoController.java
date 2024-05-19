package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmpModel;
import com.example.demo.service.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	DemoService demoService;

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody EmpModel model) throws Exception {
		demoService.add(model);
		return new ResponseEntity<String>("Added", HttpStatus.CREATED);
	}
}
