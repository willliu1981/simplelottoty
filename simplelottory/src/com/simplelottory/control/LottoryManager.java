package com.simplelottory.control;

import java.util.HashMap;
import java.util.Map;

import com.simplelottory.model.Lottory;

public class LottoryManager {
	private Map<String, Lottory> lottos;

	public LottoryManager() {
		lottos = new HashMap<>();
	}
	
	public void addLottory(String name,Lottory lottory) {
		this.lottos.put(name, lottory);
	}
	
	public void shufflt(String name) {
		this.lottos.get(name).shufflt();;
	}
	
	public Lottory getLottory(String name) {
		return this.lottos.get(name);
	}
}
