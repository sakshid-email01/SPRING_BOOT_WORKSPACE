package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Model;
import com.example.demo.service.ServiceInterface;



@RestController
public class DemoController {
	
	@Autowired
	ServiceInterface serviceInterface;
	
	@PostMapping("/create")
	public ResponseEntity<String> add(@RequestBody Model model) {
		serviceInterface.add(model);
		return new ResponseEntity<String>("added", HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> update(@RequestBody Model model) {
		serviceInterface.update(model);
		return new ResponseEntity<String>("updated", HttpStatus.CREATED);
	}
	
	@GetMapping("/read")
	public ResponseEntity<List<Model>> findAll() {
		return new ResponseEntity<List<Model>>(serviceInterface.findAll(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		serviceInterface.delete(id);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	 
	

}
