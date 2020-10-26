package com.crypto.encrypt.decrypt;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class PasswordCryptoTest {

	public static void main(String[] args) throws Exception {
		
		PasswordCryptoTest passwordTest = new PasswordCryptoTest();
		SecretKey key = passwordTest.generateNewKey();
		String password = "Tester@#$1234";
		
		String encrypted = passwordTest.encryptString(password, key);
		char[] decrypted = passwordTest.decryptString(encrypted, key);
		
		System.out.println("Password used = "+ password);
		System.out.println("Encrypted value = "+ encrypted);
		System.out.println("Decrypted value = "+ new String(decrypted));
		

	}
	
	private SecretKey generateNewKey() throws NoSuchAlgorithmException{
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128); //options are 128,192, 256
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey;
	}
	
	
	/**
	 * @param value
	 * @param secretKey
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException 
	 * @throws UnsupportedEncodingException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	private String encryptString(String value, SecretKey secretKey ) 
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException{
		
		Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		byte[] textBytes = value.getBytes("UTF-8");
		byte[] encryptedBytes = cipher.doFinal(textBytes);
		
		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedString = encoder.encodeToString(encryptedBytes);
		
		return encryptedString;	
	}
	
	/**
	 * @param value
	 * @param secretKey
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException 
	 * @throws UnsupportedEncodingException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	private char[] decryptString(String value, SecretKey secretKey ) 
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException{
		
		Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedBytes = decoder.decode(value);		
		
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		Charset utf8 = StandardCharsets.UTF_8;
		CharBuffer decryptedChars = utf8.decode(ByteBuffer.wrap(decryptedBytes));

		return decryptedChars.array();
	}
	

}
