package main;

//import java.util.regex.Pattern;
//import caesar.Encrypt;
import util.Utilities;

import caesar.Decrypt;
import caesar.Encrypt;

public class Test {	

	public static void main(String[] args) {
		
		Encrypt encrypt = new Encrypt();
		
		Decrypt decrypt = new Decrypt();
		
		String testKeyword = "caesar";
		
		String testMessage = "GO AT YOUR CONVENIENCE";
		
		encrypt.setKeyword(testKeyword);
		
		encrypt.setMessage(testMessage);
		
		String testEncryptedMessage = encrypt.EncryptMessage();
		
		System.out.println(testEncryptedMessage);
		
		decrypt.SetEncryptedMessage(testEncryptedMessage);
		
		decrypt.setKeyword(testKeyword);
		
		String testDecryptedMessage = decrypt.DecryptMessage();
		
		System.out.println(testDecryptedMessage);
		
//		String fileName = "test.txt";
//		
//		String cypherText = "`h9Zm9rhnk9\\hgo^gb^g\\^";
//		
//		try {
//		Utilities.WriteFile(fileName, cypherText);
//		} catch (IllegalArgumentException e) {
//			System.out.println("Malformed argument used: " + e);
//		}
		
//		String test = Utilities.getFileName();
		
		//String[] testing = test.split(Pattern.quote("."),2);
		
		//System.out.println(testing[0] + " " + testing[1]);
		
//		System.out.println(test);
	}

}
