package test;

import static org.junit.Assert.*;

import org.junit.Test;

import caesar.Encrypt;

public class EncryptTest {

	@Test
	public void encryptTestKnownKeyAndMessage() {
		//arrange
		String result = "";
		Encrypt encrypt = new Encrypt();
		String testKeyword = "caesar";
		String testMessage = "GO AT YOUR CONVENIENCE";
		String encryptedMessage = "`h9Zm9rhnk9\\hgo^gb^g\\^";
		//act
		encrypt.setKeyword(testKeyword);
		encrypt.setMessage(testMessage);
		result = encrypt.EncryptMessage();
		//assert
		assertEquals(encryptedMessage, result);
	}

}
