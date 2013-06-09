package com.redpois0n;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import sun.misc.BASE64Decoder;

public class StringCrypter {

	public static final String UNICODE_FORMAT = "UTF8";
	public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	public static final int KEY_LENGTH = 24;

	public static String decrypt(String k, String encryptedString) throws Exception {
		Cipher cipher = Cipher.getInstance(DESEDE_ENCRYPTION_SCHEME);
		SecretKeyFactory skf = SecretKeyFactory.getInstance(DESEDE_ENCRYPTION_SCHEME);
		DESedeKeySpec ks = new DESedeKeySpec(k.getBytes("UTF-8"));
		SecretKey sk = skf.generateSecret(ks);
		cipher.init(Cipher.DECRYPT_MODE, sk);

		byte[] decoded = new BASE64Decoder().decodeBuffer(encryptedString);

		return new String(cipher.doFinal(decoded));
	}

}
