package pers.simplelottory.control.excpetion;

public class EndOfLottoryListException extends RuntimeException {
	private static final String default_message = "End of List<Lottory>";

	public EndOfLottoryListException() {
		this(default_message);
	}

	public EndOfLottoryListException(String message) {
		super(message);
	}

	public EndOfLottoryListException(int idx) {
		super(default_message + ":" + idx);
	}
}
