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

public class practise {
	
	public static  String ALGORITHM ="AES";
	public String TRANSFORMATION ="AES";
	
	public static void encrypto(String key,File inputfile,File outfile)throws  CryptoException {
		docrypto(Cipher.ENCRYPT_MODE,key,inputfile,outfile);
	}
	
	
	public static  void decrypto(String key,File inputfile,File outputfile)throws  CryptoException{
		docrypto(Cipher.DECRYPT_MODE,key,inputfile,outputfile);
	
	}
	
 	
	private static void docrypto(int cipherMode, String key, File inputfile, File outputfile)throws  CryptoException{
		
		try {
			
			SecretKeySpec secretkey = new SecretKeySpec(key.getBytes(),ALGORITHM);
			 Cipher cipher;
			cipher.init(cipherMode, secretkey);
			
			FileInputStream inputstream = new FileInputStream(inputfile);
			byte[] inputbytes = new byte[(int)inputfile.length()];
			inputstream.read(inputbytes);
			
			FileOutputStream outputstream = new FileOutputStream(outputfile);
			byte[] outputbytes = new byte[(int)outputfile.length()];
			outputstream.write(outputbytes);
			
			
		}catch(NoSuchAlgorithmException | InvalidKeyExcepiton | 
				 BadPaddingException| IllegalBlockSizeException |
				 IOException ex){
			
			
		}
		
	}
	
	
}
