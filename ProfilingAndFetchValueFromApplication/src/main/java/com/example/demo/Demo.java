package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
// this below line is used to give source from where below variable values can be 
// fetched  if not found in the main application.properties file 
// multiple files can also be mentioned
@PropertySource("application-prod.properties")
@PropertySource("application-dev.properties")

//this line means that the bean of this class will be created only if profile is dev
//@Profile("dev")
//@Profile("!dev")
//this line means that the bean of this class will be created only if profile is dev
//@ConditionalonProperty can also be used to create conditional beans
public class Demo {
	
	@Value("${server.port}")
	private String serverPort;
	
	@Value("${msg}")
	private String msg;
	
	@Value("${prod}")
	private String prod;
	
	@Value("${dev}")
	private String dev;
	
	@Value("${defaultValue}")
	private String defaultValue;
	
	@Value("${demoValue:demo}") 
	// if variable not present in application.properties 
	//file then some default value can be assigned to variable
	private String demoValue;
	
	
	//fetch active profile
	@Value("${spring.profiles.active}")
	private String activeProfile;
	
	@Autowired
	private Environment env;

	@GetMapping("/demo")
	public void fetchValueFromApplication() {
		System.out.println("server port is "+ serverPort);
		System.out.println("msg is "+ msg);
		System.out.println("prod value is "+ prod);
		System.out.println("dev value is "+ dev);
		System.out.println("default value is "+ defaultValue);
		System.out.println("demoValue is "+ demoValue);
		System.out.println("activeProfile is "+ activeProfile);
		System.out.println("env is "+ env);
	}
	
	 
	
}
