package com.example.demo.encyption;

import com.example.demo.enums.TypesOfEncodingEnum;

// this interface is implemented by all individual encryption type classes
// mentioned in enum (eg: MD5Encryption.java, SHA1Encryption.java, 
// SHA2Encryption.java)
public interface EncryptionInterface {
    // this class returns the encryption type of each class
	public TypesOfEncodingEnum getEncryptionType();
	
	//this contains individual logic specific to each class
	public void encrypt(String toBeEncrypted);
	
}
