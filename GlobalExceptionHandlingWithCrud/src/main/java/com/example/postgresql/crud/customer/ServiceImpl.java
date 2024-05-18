package com.example.postgresql.crud.customer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.postgresql.crud.custom.exception.EmptyInputException;

@Service
public class ServiceImpl implements ServiceInterface{
	
	@Autowired
	Repository repo;

	@Override
	public Model create(Model model) {
        if(model.getName() == null || model.getName().isBlank() || model.getName().isEmpty()) {
        	// can send specific error msg and code
        	// can be kept empty, common msg and code from GlobalExceptionHandling class
        	// can be used
        	throw new EmptyInputException("601", "empty input field");
        }
		return repo.save(model);
	}

	@Override
	public Collection<Model> read() {
		// TODO Auto-generated method stub
		return (Collection<Model>) repo.findAll();
	}

	@Override
	public void update(Model model) {
		repo.save(model);
	}

	@Override
	public void delete(int id) {
	    repo.deleteById(id);	
	}

}
