package hu.algorithms.galeshapley;

public class GenderMismatchException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public GenderMismatchException() {
		super();
	}
	
	public GenderMismatchException(String message) {
		super(message);
	}

	public GenderMismatchException(Throwable cause) {
		super(cause);
	}

	public GenderMismatchException(String message, Throwable cause) {
		super(cause);
	}
	
}
