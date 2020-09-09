package assignment1;

/**
 * User defined Exception
 * 
 * @author Student Zuyi Ding
 *
 */
public class NoSpecialCharacterException extends RuntimeException {

	/**
	 * Default constructor
	 */
	public NoSpecialCharacterException() {
	}

	/**
	 * Copy constructor
	 * 
	 * @param message
	 */
	public NoSpecialCharacterException(String message) {

		super(message);
	}
}

