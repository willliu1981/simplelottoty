package pers.simplelottory.control;

import java.util.Arrays;
import java.util.List;

import pers.simplelottory.model.Lottory.LottoryType;


public class Outputs {
	public static String tip() {
		StringBuilder sb = new StringBuilder();
		Arrays.asList(LottoryType.values()).stream().sorted((x1, x2) -> x1.getValue().compareTo(x2.getValue()))
				.forEach(x -> {
					sb.append(x.getValue() + "=" + x.getDefineName() + " ");
				});
		return sb.toString();
	}

	public static <T> String foreach(List<T> list) {
		return foreach(list);
	}

	public static <T> String foreach(List<T> list, int max_count_limit) {
		StringBuilder sb = new StringBuilder();
		list.stream().limit(max_count_limit).forEach(x -> sb.append(x + "\n"));
		if (list.size() > max_count_limit) {
			sb.append("...\n");
		}
		return sb.toString();
	}
}
