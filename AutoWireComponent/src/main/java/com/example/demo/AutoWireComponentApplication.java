package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AutoWireComponentApplication {

	public static void main(String[] args) {
		
		// this will return and store an object during run time
		ConfigurableApplicationContext context = 
				SpringApplication.run(AutoWireComponentApplication.class, args);
		
		// (I) @Component runtime/dynamic object creation of ClassA 
		// (II) @Autowired used while declaring ClassZ object inside ClassA.
		// using ConfigurableApplicationContext and @Autowired,@Component annotation
		// This is a good example of Dependency Injection
		ClassA obj = context.getBean(ClassA.class);
		obj.display();  
		
		
		
	}

}
