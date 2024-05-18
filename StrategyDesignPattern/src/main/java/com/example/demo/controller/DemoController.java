package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enums.TypesOfEncodingEnum;
import com.example.demo.factorym.StrategyDesignFactory;

@RestController
public class DemoController {

	@Autowired
	StrategyDesignFactory factory;

	@GetMapping("/demo")
	public void demo(@RequestParam("encodingEnum") TypesOfEncodingEnum typesOfEncodingEnum) {
		factory.findEncryptionClassUsingEncryptionType(typesOfEncodingEnum).encrypt("demo");
	}

}
