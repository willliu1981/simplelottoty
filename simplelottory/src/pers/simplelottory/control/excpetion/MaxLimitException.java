package pers.simplelottory.control.excpetion;

public class MaxLimitException extends DrawFinishException {
	private static final String default_message = "Exceed max limit";

	public MaxLimitException() {
		this(default_message);
	}

	public MaxLimitException(String message) {
		super(message);
	}

	public MaxLimitException(int max) {
		super(default_message + ":" + max);
	}
}
