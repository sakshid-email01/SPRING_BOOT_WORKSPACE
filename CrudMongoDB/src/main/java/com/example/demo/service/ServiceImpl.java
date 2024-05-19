package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Model;
import com.example.demo.repo.Repo;

@Service
public class ServiceImpl implements ServiceInterface{
	@Autowired
	Repo repo;

	@Override
	public void add(Model model) {
		repo.save(model);
	}
	
	@Override
	public void update(Model model) {
		repo.save(model);
	}

	@Override
	public List<Model> findAll() {
		return repo.findAll();
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
	}

}
