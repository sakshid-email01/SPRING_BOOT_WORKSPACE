package com.example.demo.factorym;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.encyption.EncryptionInterface;
import com.example.demo.enums.TypesOfEncodingEnum;

@Component
//1. creates a map of encryptionType from enum class and its bean using constructor
//2. function which accepts encryptionType as input and returns its encryption class
// using search in the above created map.
// this can be used for replacement of if else statements
public class StrategyDesignFactory {

	Map<TypesOfEncodingEnum, EncryptionInterface> map;
	// map = 3 values
	// eg: <MD5, bean of MD5Encryption.java>
	// eg: <SHA1, bean of SHA1Encryption.java>
	// eg: <SHA2, bean of SHA2Encryption.java>
	
	@Autowired 
	// this constructor is autowired so that it gets called 
	// when application is getting started
	// map is created before any function call is made
	// typeOfEncryptionClassSet this variable automatically contains beans of
	// all 3 classes
	public StrategyDesignFactory(Set<EncryptionInterface> beansOfAll3EncryptionClasses) {
		createStrategy(beansOfAll3EncryptionClasses);		
	}
	
	public void createStrategy(Set<EncryptionInterface> beansOfAll3EncryptionClasses) {
		map = new HashMap<TypesOfEncodingEnum, EncryptionInterface>();
		
		beansOfAll3EncryptionClasses.stream()
		.forEach(eachEncryptionClass -> map.put(eachEncryptionClass.getEncryptionType(), eachEncryptionClass));
	}
	
	
	public EncryptionInterface findEncryptionClassUsingEncryptionType(TypesOfEncodingEnum typesOfEncodingEnum) {
		return map.get(typesOfEncodingEnum);
	}
	
	
	
}
