package com.example.demo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmpDTO;
import com.example.demo.mapper.EmpPopulatorInterface;
import com.example.demo.model.EmpModel;
import com.example.demo.repo.Repo;

@Service
public class ServiceImpl implements ServiceInterface{
	
	@Autowired
	Repo repo;

	@Override
	public EmpModel addEmp(EmpDTO empDto) {
		EmpModel empModel = EmpPopulatorInterface.INSTANCE.convertDtoToModel(empDto);
		empModel.setCreationDate(new Date());
		return repo.save(empModel);
	}

}
