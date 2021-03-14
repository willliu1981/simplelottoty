package pers.simplelottory.control;

import java.util.List;

import pers.simplelottory.model.Lottory;

public class CustomerLottoryManager extends LottoryManager {
	protected List<Lottory> lottories;
	
	public CustomerLottoryManager() {
		
	}

	@Override
	public void addLottory(Lottory lottory, LottoryType type) {
		super.addLottory(lottory, type);
	}
	
	
	
	
}
