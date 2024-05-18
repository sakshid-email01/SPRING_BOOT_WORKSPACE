package com.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.service.Producer;


@RestController
public class DemoController {
	
	@Autowired
	Producer producer;

	@GetMapping("/demo")
	//api call from client 
	public String getMethodName(@RequestParam String param) {
		producer.sendMsgToTopic(param);
		return new String(param);
	}
	
}
