package com.example.demo.batch;

import org.springframework.batch.item.ItemProcessor;

public class CustomProcessor implements ItemProcessor<String, String>{

	@Override
	public String process(String data) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Processesing data - " + data);
		data.toUpperCase();
		return data;
	}

}
