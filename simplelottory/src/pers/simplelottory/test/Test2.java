package pers.simplelottory.test;

import java.util.HashMap;
import java.util.Map;

import pers.simplelottory.control.LottoryManager.LottoryType;

public class Test2 {
	public static void main(String s[]) {
		Map<String, LottoryType> lottory_type_map = (Map<String, LottoryType>) new HashMap<>().put("1",
				LottoryType.BigLotto);
		
		System.out.println(lottory_type_map.get("1"));
		
		
	}
}
