package src.Assign3;

public class InvalidArgumentsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidArgumentsException() {
		super("You did not provide enough arguments.");
	}

}
