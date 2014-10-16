package su.jrat.reverser;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {
		
	public static byte[] decrypt(byte[] bytes, byte[] key) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");

		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"));
		
		return cipher.doFinal(bytes);
	}
	
	public static byte[] encrypt(byte[] bytes, byte[] key) throws Exception {
		Cipher cipher = Cipher.getInstance("AES");
	
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));
		
		return cipher.doFinal(bytes);
	}

}
