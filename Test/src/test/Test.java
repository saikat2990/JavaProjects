package test;

import java.awt.RenderingHints.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Test {
	public static void main(String args[]) throws Exception {
		
		KeyGenerator kg = KeyGenerator.getInstance("DES");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		java.security.Key key = kg.generateKey();
		
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		byte[]input = "Son of bitch".getBytes();
		byte[]encrypted = cipher.doFinal(input);
		byte[]iv = cipher.getIV();
		
		IvParameterSpec dps = new IvParameterSpec(iv);
		cipher.init(Cipher.DECRYPT_MODE, key,dps);
		byte[]output =cipher.doFinal(encrypted);
		
		System.out.println(new String (output));
		
		
		
	}
}
