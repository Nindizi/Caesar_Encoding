package util;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

/**
 * Small utilities class to handle general tasks that are not specific
 * to encrypting or decrypting a plaintext message.
 * <p>
 * @since		1.0
 * @author 		Mark Dietzler
 * 
 */

public class Utilities {

	/**
	 * Menu choice, prints the passed in prompt, and only accepts valid integer
	 * input
	 *  
	 * @param prompt	The prompt for the user to read
	 * @param high		The highest valid menu choice number
	 * @return the chosen menu choice as an int
	 */
	public static int getMenuInput(String prompt, int high) {
		Scanner scan = new Scanner(System.in);
		
		int choice = -1;
		boolean successfull = false;
		boolean reprompt = false;
		boolean nonint = false;
		
		System.out.println(prompt);

		do {			
			// get menu choice from keyboard
			
			if(reprompt) {
				System.out.println("Try again. Enter a choice between 0 and " + high + ".");
				reprompt = false;
			} 
			
			try {
				choice = scan.nextInt();				
			} catch (InputMismatchException e) {
				System.out.println("Incorrect input, enter an integer...");				
				nonint = true;
				scan.nextLine();
			}
			
			//validate high and low limit only if valid int was entered 
			if(!nonint) {				
				if(choice > high) { //outside of high limit
					reprompt = true;
					scan.nextLine();
				} else if (choice < 0){ //less than zero
					reprompt = true;
					scan.nextLine();
				} else {				//valid menu choice, set loop flag to exit loop
					successfull = true;
				}				
			} else {
				//only here if came from catch block from non int input
				nonint = false;
			}

		} while (!successfull);
		scan.close();
		return choice;
	}

	/**
	 * Gets file name from console input
	 * 
	 * @return
	 */
	public static String getFileName() {
		boolean passedTest = false;
		String fileName;
		//String[] testFileName;	
		
		do {
			System.out.println("Enter file name with a .txt extension:\n");
			Scanner scan = new Scanner(System.in);
			fileName = scan.next();
			
			if(fileName.contains(".")) {
				
				String[]testFileName = fileName.split(Pattern.quote("."),2);
				
				if(testFileName[1].contains("txt")) {
					passedTest = true;
					scan.close();
				} else {
					System.out.println("Use the correct txt file extension.\n");
				}
				
			} else {
				System.out.println("Enter a filename in the requested format: name.txt\n");
			}
		} while (!passedTest);
		
		return fileName;
	}

	/**
	 * Validates user choice from menu
	 * 
	 * @param value int passed from scanner
	 * @return true or false
	 */
	public static boolean IsMenuChoiceValid(int value, int low, int high) {

		if (value < low) {
			return false;
		} else if (value > high) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validates entered text for null, empty, or blank (spaces only)
	 * 
	 * @param checkMe Text to check
	 * @return True if string is valid, false if not. False by default.
	 */
	public static boolean IsTextValid(String checkMe) {
		boolean returnMe = false;
		if (checkMe != null && checkMe.isEmpty() && checkMe.isBlank()) {
			returnMe = IsText(checkMe);
		}
		return returnMe;
	}

	/**
	 * Validates keyword for letter only
	 * 
	 * @param stringToCheck - the keyword to check
	 * @return - false if any character in the keyword is not a letter, true if it
	 *         is
	 */

	public static boolean IsText(String stringToCheck) {
		char[] charArrayToCheck = stringToCheck.toCharArray();
		for (char c : charArrayToCheck) {
			if (!Character.isLetter(c)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Gets string input from console
	 * 
	 * @param instructions
	 * @return
	 */
	public static String UserInput(String instructions) {
		Scanner scan = new Scanner(System.in);
		System.out.println(instructions);
		String returnMe = scan.next();
		scan.close();
		return returnMe;
	}
	
	/**
	 * Writes a file with the given file name and given cypher text.
	 * 
	 * @param filename The name of the file to write
	 * @param cipherText The encoded message to write
	 * 
	 * @throws IllegalArgumentException
	 */
	public static void WriteFile(String filename, String cipherText) throws IllegalArgumentException {
		
		if(filename.isBlank() || filename.isEmpty()) {
			throw new IllegalArgumentException("File name cannot be empty or blank!");
		}
		
		if(cipherText.isBlank() || cipherText.isEmpty()) {
			throw new IllegalArgumentException("Cipher text cannot be empty or blank!");
		}
		
		File file = new File(filename);
		try {
			PrintWriter pw = new PrintWriter(file);
			pw.println(cipherText);
			pw.close();
		} catch (IOException e) {			
			System.out.println("Error writing file: " + e);
		}		
	}

}
