package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.EmpModel;
import com.example.demo.repo.DemoRepo;

@Service
public class DemoServiceImpl implements DemoService{

	@Autowired
	DemoRepo demoRepo;
	
	
	@Transactional(rollbackFor = Exception.class)
	public EmpModel add(EmpModel model) throws Exception  {
		 //1st transaction
         EmpModel savedEmp = demoRepo.save(model);
         System.out.println("1st transaction done");
         
         //throwing exception to check transaction management impl
         if(savedEmp.getName().equalsIgnoreCase("test")) {
        	 throw new Exception();
         }
         //2nd transaction
         EmpModel model1 = new EmpModel ();
         model1.setEmailId("demo@demo.com");
         model1.setName("demo"); 
         demoRepo.save(model1);
         System.out.println("2nd transaction done");
         
         return savedEmp;
	}
	


}
