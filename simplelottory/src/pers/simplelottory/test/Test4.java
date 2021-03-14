package pers.simplelottory.test;

import java.util.List;

import pers.simplelottory.control.BigLottoDraw;
import pers.simplelottory.control.CustomerLottoryManager;
import pers.simplelottory.control.LottoryManager.LottoryType;
import pers.simplelottory.model.CustomerLottory;
import pers.simplelottory.model.Lottory;
import pers.simplelottory.model.Pool;

public class Test4 {

	public static void main(String[] args) {
		// CustomerLottory cl=new CustomerLottory(new Pool(39, 5));
		List<Integer> lists;

		try {
			test_method();

		} catch (RuntimeException ex) {
			System.out.println(ex.getMessage());
		}
		

	}

	public static void test_method() {
		
		test_inner_method();
	}

	public static void test_inner_method() {
		throw new RuntimeException("xxx");
	}

}
