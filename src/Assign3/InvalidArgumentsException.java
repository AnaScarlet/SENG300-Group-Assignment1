/**
 * @authors			    Anastasiya Lazarenko, Matthew Buhler, Zachary Hull
 * @team                1
 * @version             Group Assignment 1
 * @since               March 14th, 2018
 *
 * Course:              SENG300, University of Calgary
 * Instructor:          Prof. Robert Walker
 * 
 * This class has one method and is designed to provide an error statement
 * when the right number of arguments were not given.
 */


package src.Assign3;

public class InvalidArgumentsException extends Exception {

	private static final long serialVersionUID = 1L;			//Serial version
	
	
	/**
	 * Sends an error message to the parent class when an invalid
	 * argument exception has been found
	 */
	
	public InvalidArgumentsException() {
		super("You did not provide enough arguments.");			//String argument to be sent to parents method
	}

}
