package com.example.demo.crud;

import java.util.Collection;

public interface ServiceInterface {
	
	public abstract void create(Model model);
	public abstract Collection<Model> read();
	public abstract void update(Model model);
	public abstract void delete(int id);

}
