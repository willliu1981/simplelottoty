package pers.simplelottory.control;

import java.util.Arrays;

import pers.simplelottory.control.LottoryManager.LottoryType;

public class Inputs {
	public static String tip() {
		StringBuilder sb = new StringBuilder();
		Arrays.asList(LottoryType.values()).stream().sorted((x1, x2) -> x1.getValue().compareTo(x2.getValue()))
				.forEach(x -> {
					sb.append(x.getValue() + "=" + x.getDefineName() + " ");
				});
		return sb.toString();
	}
}
