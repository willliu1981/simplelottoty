package pers.simplelottory.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pers.simplelottory.model.CustomerLottory;
import pers.simplelottory.model.Lottory;

public class CustomerLottoryManager extends LottoryManager {
	protected Map<String,CustomerLottory> lottoriesMap;//map<define name, class type List<Lottory>>
	
	public CustomerLottoryManager() {
		this.lottoriesMap=new HashMap<>();
	}

	@Override
	public void addLottory(Lottory lottory, LottoryType type) {
		this.lottoriesMap.get(type.getDeclaringClass());
	}

	@Override
	public Lottory getLottory(LottoryType type) {
		return this.lottoriesMap.get(type.getDeclaringClass());
	}
	
	
	
	
}
