package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Model;

@Repository
public interface Repo extends MongoRepository<Model, Integer>{

}
