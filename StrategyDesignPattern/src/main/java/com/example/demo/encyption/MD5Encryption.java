package com.example.demo.encyption;

import org.springframework.stereotype.Service;

import com.example.demo.enums.TypesOfEncodingEnum;

@Service
public class MD5Encryption implements EncryptionInterface{

	@Override
	public TypesOfEncodingEnum getEncryptionType() {
		return TypesOfEncodingEnum.MD5;
	}

	@Override
	public void encrypt(String toBeEncrypted) {
		System.out.println("This String is from md5encryption. java class file");
	}

}
