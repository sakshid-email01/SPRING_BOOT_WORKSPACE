package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ReceiverEmailDataDetails;
import com.example.demo.service.SendEmailInterface;

@RestController
public class EmailController {

	@Autowired
	private SendEmailInterface sendEmailInterface;

	@GetMapping("/sendEmail")
	public ResponseEntity<String> sendEmail(@RequestBody ReceiverEmailDataDetails receiverEmailData) {
		sendEmailInterface.sendEmail(receiverEmailData.getReceiverEmailId(), receiverEmailData.getEmailContent(),
				receiverEmailData.getEmailSubjectHeading());
		return new ResponseEntity<String>("email sent", HttpStatus.OK);
	}

}
