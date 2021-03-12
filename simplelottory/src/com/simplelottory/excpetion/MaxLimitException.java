package com.simplelottory.excpetion;

public class MaxLimitException extends RuntimeException {
	public MaxLimitException() {
		super("Exceed max limit");
	}
}
