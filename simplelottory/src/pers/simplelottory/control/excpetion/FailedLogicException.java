package pers.simplelottory.control.excpetion;

public class FailedLogicException extends RuntimeException {
	private static final String default_message = "Failed Logic";

	public FailedLogicException() {
		this(default_message);
	}

	public FailedLogicException(String message) {
		super(message);
	}

	public FailedLogicException(int size) {
		super(default_message + ":" + size);
	}
}
