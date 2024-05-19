package com.example.demo.crud;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements ServiceInterface{
	
	@Autowired
	Repository repo;

	@Override
	public void create(Model model) {
		System.out.println(model.toString());
		repo.save(model);
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
