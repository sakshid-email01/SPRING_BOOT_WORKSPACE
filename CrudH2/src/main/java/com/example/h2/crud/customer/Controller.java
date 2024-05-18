package com.example.h2.crud.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
	
	@Autowired
	ServiceInterface customerService;
	
	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestBody Model model) {
		customerService.create(model);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/findAll")
	   public ResponseEntity<Object> read() {
	      return new ResponseEntity<>(customerService.read(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	   public ResponseEntity<Object> delete(@PathVariable("id") int id) {
		 customerService.delete(id);
	      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}
	
	@PatchMapping("/update/{id}")
	   public ResponseEntity<Object> update(@PathVariable("id") int id, @RequestBody Model model) {
	      customerService.update(id, model);
	      return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	   }

}
