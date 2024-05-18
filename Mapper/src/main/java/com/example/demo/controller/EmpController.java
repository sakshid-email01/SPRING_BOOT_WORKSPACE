package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmpDTO;
import com.example.demo.model.EmpModel;
import com.example.demo.service.ServiceInterface;

@RestController
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	ServiceInterface serviceInterface;
	
	@PostMapping("/add")
	public ResponseEntity<EmpModel> addEmp(@RequestBody EmpDTO empDto) {
		return new ResponseEntity<EmpModel>(serviceInterface.addEmp(empDto), HttpStatus.CREATED);
	}
	
	
}
