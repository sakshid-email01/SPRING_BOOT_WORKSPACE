package com.example.demo.encyption;

import org.springframework.stereotype.Service;

import com.example.demo.enums.TypesOfEncodingEnum;

@Service
public class SHA2Encryption implements EncryptionInterface{

	@Override
	public TypesOfEncodingEnum getEncryptionType() {
		return TypesOfEncodingEnum.SHA2;
	}

	@Override
	public void encrypt(String toBeEncrypted) {
		System.out.println("This String is from sha2encryption. java class file");
	}

}
