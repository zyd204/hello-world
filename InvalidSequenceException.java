
package assignment1;

/**
 * User defined Exception class
 * @author Student Zuyi Ding
 *
 */
public class InvalidSequenceException extends RuntimeException {
    
	/**
	 * Default constructor   
	 */
	public InvalidSequenceException() {}

	/** 
	 * Copy constructor
	 * @param message
	 */
	public InvalidSequenceException(String message) {

	      super(message);
	   }
}


