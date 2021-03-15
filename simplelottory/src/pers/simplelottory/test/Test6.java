package pers.simplelottory.test;

import java.util.HashMap;
import java.util.Map;

import pers.simplelottory.control.Outputs;
import pers.simplelottory.model.Lottory.LottoryType;

public class Test6 {

	public static void main(String[] args) {
		Map<String ,String> map=new HashMap<>();
		map.put(LottoryType.BigLotto.getDefineName(), "RRR");
		LottoryType type=LottoryType.BigLotto;
		System.out.println(type);
		System.out.println(type.getDefineName());
		System.out.println(type.toString()==type.getDefineName());
		System.out.println(map.get(type));//<<bug ??
		System.out.println(map.get(type.getDefineName()));
		
		System.out.println(Outputs.tip()) ;
	}

}
