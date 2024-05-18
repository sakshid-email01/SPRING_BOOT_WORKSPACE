package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.EmpDTO;
import com.example.demo.model.EmpModel;

@Mapper
public interface EmpPopulatorInterface {
	
	//an interface can not create object so it has its own instance
	EmpPopulatorInterface INSTANCE = Mappers.getMapper(EmpPopulatorInterface.class);

	@Mapping(target="id", ignore=true)
	@Mapping(target="creationDate", ignore=true)
	EmpModel convertDtoToModel(EmpDTO empDto);
}
