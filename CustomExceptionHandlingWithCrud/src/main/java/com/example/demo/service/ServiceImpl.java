package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.custom.exception.BusinessExceptionHandling;
import com.example.demo.model.Model;
import com.example.demo.repo.Repo;

@Service
public class ServiceImpl implements ServiceInterface {

	@Autowired
	Repo repo;

	@Override
	public Model create(Model model) {
		if (model.getName() == null || model.getName().isEmpty()
				|| model.getName().isBlank()) {
			throw new BusinessExceptionHandling("601", "Name is blank.");
		}
		try {
			Model savedModel = repo.save(model);
			return savedModel;
		}
		 //this exception is default exception of .save() method.
		 //its mentioned in the function description.
		catch (IllegalArgumentException e) {
			throw new BusinessExceptionHandling("602", "request is null" + e.getMessage());
		} catch (Exception e) {
			throw new BusinessExceptionHandling("603", "general error in serviceImpl" + e.getMessage());
		}
	}

	

}
