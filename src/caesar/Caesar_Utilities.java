package caesar;

public class Caesar_Utilities {
	
	private static final int MODULOUS = 26;
	
	/**
	 * Generate the shift value from the validated keyword
	 * @param validKeyword Keyword to generate shift value from
	 * @return shift value
	 */
	private static int GenerateShift(String validKeyword) {
		
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
