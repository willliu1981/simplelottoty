package com.simplelottory.excpetion;

public class DrawFinishException extends RuntimeException {
	private static final String default_message = "Draw Finish";

	public DrawFinishException() {
		this(default_message);
	}

	public DrawFinishException(String message) {
		super(message);
	}

}
