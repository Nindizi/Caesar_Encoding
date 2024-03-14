package caesar;

public class Decrypt {
	
	private String decryptedMessage;
	private String keyword;
	private String encryptedMessage;
	private int shift = -1;
	private static final int MODULOUS = 26;	
	private static final String MESSAGEPROMPT = "Enter your encrypted message in text. Press enter when finished: ";
	private static final String KEYWORDPROMPT = "Enter a keyword to decrypt with, using only letters: ";
	private static final String ENTEREDMESSAGETEXT = "Entered encrypted text message: ";
	private static final String ENTEREDKEYWORDTEXT = "Entered keyword to decrypt with: ";
	private static final String ENTRYERRROR = "You entered an invalid character, try again: ";
	private static final String CHOICEPROMPT = "Will you be entering the cyper text yourself, or reading from a file?";
	
	public String getDecyryptedMessage() {
		return decryptedMessage;
	}

	public void setDecryptedMessage(String message) {
		this.decryptedMessage = message.toUpperCase();
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
	
	public void SetEncryptedMessage(String newEncryptedMessage) {
		this.encryptedMessage = newEncryptedMessage.toUpperCase();
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
	
	public String DecryptMessage() {
		return "GO AT YOUR CONVENIENCE";
	}
	
	private String GetText() {
		return "XX";
	}
	
	private void ApplyShift() {
		
	}
	
	private void Dechipher() {
		
	}

}
