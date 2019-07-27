package net.codejava.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;

public class Cryptoutil {
	
	public static final String ALGORITHM = "AES";
	public static final String TRANSFORMATION = "AES";
	
	public static void encrypt(String key, File inputFile, File outputFile)throws CryptoException {
		doCrypto(Cipher.ENCRYPT_MODE,key,inputFile,outputFile);
	}
	
	public static void decrypt(String key, File inputFile, File outputFile)throws CryptoException {
		doCrypto(Cipher.DECRYPT_MODE,key,inputFile,outputFile);
	}

	private static void doCrypto(int cipherMode, String key, File inputFile, File outputFile)
			throws CryptoException {
		 
		
		try {
			 
			SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(),ALGORITHM);
		      Cipher cipher;
			//Cipher cipher = Cipher.getInstance(TRANSFORMATION) ;                                                                                                                                                                                                                        	 Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			 cipher.init(cipherMode, secretKey);
			 
			 FileInputStream inputStream = new FileInputStream(inputFile);
			 byte [] inputBytes = new byte[(int) inputFile.length()];
			 inputStream.read(inputBytes);
			 
			 FileOutputStream outputStream = new  FileOutputStream(outputFile);
			 byte [] outputBytes = new byte[(int)outputFile.length()];
			 outputStream.write(outputBytes);
			 
			 inputStream.close();
			 outputStream.close();
			 
		 }
		
		 catch( NoSuchAlgorithmException | InvalidKeyExcepiton | 
				 BadPaddingException| IllegalBlockSizeException |
				 IOException ex) {
			 throw new CryptoException("Error encrypting/decrypting file",ex);
		 }
		
		
	}
	
}
