package com.example.postgresql.crud.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	ServiceInterface customerService;

	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestBody Model model) {
		Model modelSaved = customerService.create(model);
		return new ResponseEntity<>("Product is created successfully" + modelSaved, HttpStatus.CREATED);
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

	@PatchMapping("/update")
	public ResponseEntity<Object> update(@RequestBody Model model) {
		customerService.update(model);
		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}

}
