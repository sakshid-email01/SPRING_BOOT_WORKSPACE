package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService implements SendEmailInterface{

    @Autowired
    private JavaMailSender javaMailSender;
    
    @Value("${spring.mail.username}")
    private String fromEmailId;
    
    public void sendEmail(String recipient, String content, String subject) {
    	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    	simpleMailMessage.setFrom(fromEmailId);
    	simpleMailMessage.setTo(recipient);
    	simpleMailMessage.setText(content);
    	simpleMailMessage.setSubject(subject);
    	
    	javaMailSender.send(simpleMailMessage);
    }
    
    
    
}
