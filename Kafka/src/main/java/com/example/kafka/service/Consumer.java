package com.example.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	
	@KafkaListener(topics = "demo_topic", groupId = "demo_group")
	public void listenToTopic(String receivedMsg) {
		System.out.println("the msg received is "+ receivedMsg);
	}

}
