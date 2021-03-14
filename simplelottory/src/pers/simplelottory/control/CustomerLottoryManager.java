package pers.simplelottory.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pers.simplelottory.model.CustomerLottory;
import pers.simplelottory.model.Lottory;

public class CustomerLottoryManager extends LottoryManager {
	protected Map<String, CustomerLottory> lottoriesMap;// map<define name, class type List<Lottory>>

	public CustomerLottoryManager() {
		this.lottoriesMap = new HashMap<>();
	}

	@Override
	public void addLottory(Lottory lottory, LottoryType type) {
		this.lottoriesMap.get(type.getDefineName());
	}

	@Override
	public Lottory getLottory(LottoryType type) {
		Lottory lottory = null;
		if (this.lottoriesMap.get(type.getDefineName()).next()) {
			lottory = this.lottoriesMap.get(type.getDefineName()).get();
		}
		return lottory;
	}

}
