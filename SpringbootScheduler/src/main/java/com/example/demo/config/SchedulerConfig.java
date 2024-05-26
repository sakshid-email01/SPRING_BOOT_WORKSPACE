package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerConfig {
	
	@Scheduled(fixedDelay = 2000) 
	public void helloWorld1() throws InterruptedException{
		System.out.println("Running scheduler: Hello World1");
	}
	@Scheduled(fixedRate = 2000)
	public void helloWorld2() throws InterruptedException{
		System.out.println("Running scheduler: Hello World2");
	}
	@Scheduled(cron = "* * * * * *")
	public void helloWorld3() throws InterruptedException{
		System.out.println("Running scheduler: Hello World3");
	}

}
