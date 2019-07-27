package net.codejava.crypto;


import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;

public class Java2 {
	
	public static void main(String args[]) throws Exception {
		
		KeyGenerator kg =  KeyGenerator.getInstance("DES");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		Key key =  kg.generateKey();
		
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		byte[] input = "Stand and Unfold yourself".getBytes();
		byte[] encrypted = cipher.doFinal(input);
		byte[] iv = cipher.getIV();
		
		IvParameterSpec dps = new IvParameterSpec(iv); 
		cipher.init(Cipher.DECRYPT_MODE, key,dps);
		byte[] output = cipher.doFinal(encrypted);
		
		System.out.println(new String(output));
	}
}
