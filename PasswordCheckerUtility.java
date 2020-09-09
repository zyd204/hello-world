package assignment1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

/**
 * This class checks password validation. If a password does not meet 
 * a password requirement, throws its related error excep;tion
 * @author john
 *
 */
public class PasswordCheckerUtility {
	
	/**
	 * Default constructor
	 */
	public PasswordCheckerUtility() {
		
	}

	/**
	 * Checks validation of password argument passed to this method
	 * @param paswordString
	 * @return true If a password is valid, or false if not.
	 */
	public static boolean isValidPassword(String paswordString) {
		boolean status = true;

		// Checks password length
		try {
			if (paswordString.length() < 6) {
				throw new LengthException();
			}
		} catch (LengthException e) {
			JOptionPane.showMessageDialog(null, "The password must be at least 6 characters long", "Password Error",
					+JOptionPane.PLAIN_MESSAGE);
			status = false;
		}

		// Checks NoUpperAlphaException
		try {
			if (!paswordString.matches(".*[A-Z].*")) {
				throw new NoUpperAlphaException();
			}
		} catch (NoUpperAlphaException e) {
			JOptionPane.showMessageDialog(null, "The password must contain at least one uppercase alphabetic character",
					"Password Error", +JOptionPane.PLAIN_MESSAGE);
			status = false;
		}

		// Checks NoLowerAlphaException
		try {
			if (!paswordString.matches(".*[a-z].*")) {
				throw new NoLowerAlphaException();
			}

		} catch (NoLowerAlphaException e) {
			JOptionPane.showMessageDialog(null, "The password must contain at least one lowercase alphabetic character",
					"Password Error", +JOptionPane.PLAIN_MESSAGE);
			status = false;
		}

		// Checks NoDigitException
		try {
			if (!paswordString.matches(".*\\d.*")) {
				throw new NoDigitException();
			}
		} catch (NoDigitException e) {
			JOptionPane.showMessageDialog(null, "The password must contain at least one digit", "Password Error",
					+JOptionPane.PLAIN_MESSAGE);
			status = false;
		}

		// Checks NoSpecialCharacterException
		try {
			Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
			Matcher matcher = pattern.matcher(paswordString);
			if (matcher.matches()) {
				throw new NoSpecialCharacterException();
			}
		} catch (NoSpecialCharacterException e) {
			JOptionPane.showMessageDialog(null, "The password must contain at least one special character.",
					"Password Error", +JOptionPane.PLAIN_MESSAGE);
			status = false;
		}
		// Checks InvalidSequenceException
		try {
			char ch1, ch2, ch3;
			for (int i = 0; i < paswordString.length() - 2; i++) {
				ch1 = (char) paswordString.charAt(i);
				ch2 = (char) paswordString.charAt(i + 1);
				ch3 = (char) paswordString.charAt(i + 2);
				if (ch1 == ch2 && ch1 == ch3) {
					throw new InvalidSequenceException();
				}
			}

		} catch (InvalidSequenceException e) {
			JOptionPane.showMessageDialog(null,
					"The password cannot contain more than two of the same character in sequence." + "in sequence",
					"Password Error", +JOptionPane.PLAIN_MESSAGE);
			status = false;
		}

		return status;
	}

	/**
	 * Checks a password length is too short 
	 * @param passwwordString
	 * @return true If it is less than 10, or false if 10 or more characters.
	 */
	public static boolean isWeakPassword(String passwwordString) {
		boolean status = true;
		
		// Checks WeakPasswordException
		try
		{
			if (passwwordString.length() >= 6 && passwwordString.length() < 10)
			   {
				 throw new WeakPasswordException();
			   }
		      else
		       {
		    	  JOptionPane.showMessageDialog(null, "Strong Password", "Password Status", + JOptionPane.PLAIN_MESSAGE); 
		       }
		    	  
		 }
		    catch (WeakPasswordException e)
		{
		      JOptionPane.showMessageDialog(null, "The password is OK but weak - it contains fewer than 10 characters.", 
					   "Password status", + JOptionPane.PLAIN_MESSAGE);
		     status = false;
		 
		}
		
		if (status)
		{
			 JOptionPane.showMessageDialog(null, "Password is valid.", 
					   "Password status", + JOptionPane.PLAIN_MESSAGE);
		}
			

		return status;

	}

	/**
	 * Reads paswords from a password file, check each password validation, adds invalid passwords
	 * to a new ArrayList.
	 * @param paswords
	 * @return ArrayList It contains all invalid passwords with error explanation.
	 */
	public static ArrayList<String> validPasswords(ArrayList<String> paswords) {

		ArrayList<String> invalidPasswords = new ArrayList<>();

		return invalidPasswords;
	}

}

