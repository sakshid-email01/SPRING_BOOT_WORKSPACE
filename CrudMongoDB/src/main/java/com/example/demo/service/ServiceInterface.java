package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Model;

public interface ServiceInterface {
	
	public void add(Model model);
	public void update(Model model);
	public List<Model> findAll();
	public void delete(int id);

}
