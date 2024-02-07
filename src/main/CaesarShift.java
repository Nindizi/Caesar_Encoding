package main;
import caesar.*;
import util.Utilities;

public class CaesarShift {

	public static void main(String[] args) {
		
		int choice = -1;
		final int MAXMENUINT = 3;
		final String PROMPT = "If encrypting press 1, press 2 to decrypt, or 3 to exit: ";
		
		Decrypt decrypter;
		Encrypt encrypt = new Encrypt();		
		
		System.out.println("Prototype for a Caesar Shift encoding application.\nThs program will help you encrypt a message or decrypt a coded message.\n");		
		
		do {
				
		choice = Utilities.getMenuInput(PROMPT, MAXMENUINT);
		
		if (choice == 1) {
			
			//encrypt.
			encrypt.keywordEntry(encrypt.keywordPrompt());
			encrypt.messageEntry(encrypt.messagePrompt());
			
			System.out.println(encrypt.getEnteredKeyword() + encrypt.getKeyword());
			System.out.println(encrypt.getEnteredMessage() + encrypt.getMessage());
			
			String fileName = Utilities.getFileName();
			
			Utilities.WriteFile(fileName, fileName);
			
			break;
		} else if (choice == 2) {
			decrypter = new Decrypt();
			decrypter.DecryptMessage();
			break;
		} else if (choice == 3) {
			System.out.println("Exiting\n");
		} else {
			System.out.println("Incorrect choice....");
			//choice = -1;
		}
		} while(choice != 3);	
		
	}
	
	//start main methods
	
	//end main methods

}
