package pers.simplelottory.test;

import java.util.Arrays;

import pers.simplelottory.model.Lottory.LottoryType;


public class Test3 {

	public static void main(String[] args) {
		LottoryType t = LottoryType.valueOf("BigLotto");
		System.out.println(t.name());

		LottoryType t2 = Arrays.asList(LottoryType.values()).stream().filter(x -> {
			return x.getValue().equalsIgnoreCase("2");
		}).findFirst().get();
		System.out.println(t2);
	}

}
