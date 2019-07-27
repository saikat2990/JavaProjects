package net.codejava.crypto;

import java.io.FileInputStream;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt{
	
	public Encrypt(String strClearTxt,String strKey) throws Exception{
		String strData ="";
		
		try {
			
			SecretKeySpec skeys pec= new SecretKeySpec(strKey.getBytes(),"Blowfish"); 
			
			//FileInputStream inputfile = new   FileInputStream("as");
			
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted = cipher.doFinal(strClearTxt.getBytes());
			
			strData = new String(encrypted);

		}catch(Exception e) {
			
		}
	}
}
