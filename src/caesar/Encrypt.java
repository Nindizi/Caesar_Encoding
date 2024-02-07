package caesar;

import java.util.Scanner;

import util.Utilities;

public class Encrypt {
	
	private String message;
	private String keyword;
	private String encryptedMessage;
	private int shift = -1;
	private static final int MODULOUS = 26;	
	private static final String MESSAGEPROMPT = "Enter your message in plain text. Press enter when finished: ";
	private static final String KEYWORDPROMPT = "Enter a keyword to encrypt with, using only letters: ";
	private static final String ENTEREDMESSAGETEXT = "Entered plain text message: ";
	private static final String ENTEREDKEYWORDTEXT = "Entered keyword: ";
	private static final String ENTRYERRROR = "You entered an invalid character, try again: ";
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message.toUpperCase();
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}
	
	public String GetEncryptedMessage() {
		return encryptedMessage;
	}	
	
	public String messagePrompt() {
		return MESSAGEPROMPT;
	}
	
	public String keywordPrompt() {
		return KEYWORDPROMPT;
	}
	
	public String getEnteredMessage() {
		return ENTEREDMESSAGETEXT;
	}
	
	public String getEnteredKeyword() {
		return ENTEREDKEYWORDTEXT;
	}
	
	public String getEntryError() {
		return ENTRYERRROR;
	}

	/**
	 * Encrypts the stored message using shift values from the stored keyword. That the keyword and message
	 * to encrypt are set already is assumed.
	 * 
	 *  @return encryptedMessage The stored encrypted message is returned in String form.
	 */
	public String EncryptMessage() {
				
		setShift(GenerateShift(keyword));
		
		char[] messageArray = message.toCharArray();
		
		char[] encryptedArray = new char[messageArray.length];
		
		for (int i = 0; i < encryptedArray.length; i++) {
			int existing = messageArray[i] + shift;
			encryptedArray[i] = (char) existing;			
		}
		
		encryptedMessage = String.valueOf(encryptedArray);
		
		//message = "ENCRYPTING using shift of: " + getShift();
		
		return encryptedMessage;
	}
	
	/**
	 * Gets encryption keyword from user. Only accepts letters; no punctuation, spaces, or numbers.
	 * 
	 * @param givenInstructions Instructions for entering a keyword.
	 */
	public void keywordEntry(String givenInstructions) {
		
		Scanner scan = new Scanner(System.in);
		String temp = "";
		boolean badWord = false;
		boolean validEntry = false;
		
		do {
			if(badWord) {
				System.out.println(ENTRYERRROR);
				badWord = false;
			} else {
				System.out.println(givenInstructions);
			}
			
			temp = scan.nextLine();
			
			validEntry = Utilities.IsText(temp);
			
			if(!validEntry) {
				badWord = true;
			}
			
		} while(!validEntry);
		
		scan.close();
		
		this.keyword = temp;
		
	}
	
	public void messageEntry(String instructions) {
		this.setMessage(Utilities.UserInput(instructions));
	}
	
	/**
	 * Generate the shift value from the validated keyword
	 * @param validKeyword Keyword to generate shift value from
	 * @return shift value
	 */
	private int GenerateShift(String validKeyword) {
		
		int returnShift = 0;
		
		char[] asciiAddition = validKeyword.toCharArray();
		
		for(char c : asciiAddition) {
			returnShift+= (int) c;
		}
		
		returnShift = returnShift%MODULOUS;
		
		if(returnShift == 0) {
			returnShift = 1;
		}
		
		return returnShift;
	}
	
}
