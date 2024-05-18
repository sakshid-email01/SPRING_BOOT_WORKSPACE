package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	Logger logger = LoggerFactory.getLogger("demo_logger_check");

	@GetMapping("/demo")
	public void demo() {
		logger.trace("checking trace logger message");
		logger.info("checking info logger message");
		System.out.println("running");
	}
}
