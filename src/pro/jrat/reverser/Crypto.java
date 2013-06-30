package pro.jrat.reverser;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {
	
	public static final String ENCRYPTION_ALGORITHM = "AES";
	
	public static byte[] decrypt(byte[] bytes, byte[] key) throws Exception {
		Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);

		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, ENCRYPTION_ALGORITHM));
		
		return cipher.doFinal(bytes);
	}
	
	public static byte[] encrypt(byte[] bytes, byte[] key) throws Exception {
		Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
	
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, ENCRYPTION_ALGORITHM));
		
		return cipher.doFinal(bytes);
	}

}
