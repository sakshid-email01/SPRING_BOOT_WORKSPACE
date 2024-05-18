package com.example.h2.crud.customer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements ServiceInterface{
	@Autowired
	Repository repo;

	@Override
	public void create(Model model) {
		repo.save(model);
	}

	@Override
	public Collection<Model> read() {	
		return (Collection<Model>) repo.findAll();
	}

	@Override
	public void update(int id, Model model) {
	    repo.save(model);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}

}
