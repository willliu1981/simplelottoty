package pers.simplelottory.control;

import java.util.HashMap;
import java.util.Map;

import pers.simplelottory.model.CustomerLottory;
import pers.simplelottory.model.Lottory;

public class CustomerLottoryManager extends LottoryManager {
	protected Map<String, CustomerLottory> lottoriesMap;// map<define name, class type List<Lottory>>
	protected static Integer period = 0;

	public CustomerLottoryManager() {
		this.lottoriesMap = new HashMap<>();
	}

	protected void addElementOfCustomerLottory(Lottory lottory, LottoryType type) {
		this.getCustomerLottory(type) .add(lottory);
	}

	protected CustomerLottory getCustomerLottory(LottoryType type) {
		CustomerLottory cl = null;
		if (this.lottoriesMap.containsKey(type)) {
			cl = this.lottoriesMap.get(type);
		} else {
			cl = new CustomerLottory(period);
			this.lottoriesMap.put(type.getDefineName(), cl);
		}
		return cl;
	}

	protected Lottory getElementOfCustomerLottory(LottoryType type) {
		Lottory lottory = null;
		if (this.lottoriesMap.get(type.getDefineName()).next()) {
			lottory = this.lottoriesMap.get(type.getDefineName()).get();
		}
		return lottory;
	}

	public Lottory createNewLottory(LottoryType type) {
		this.shuffle(type);
		Lottory draw = this.draw(type);
		this.addElementOfCustomerLottory(draw, type);
		return draw;
	}

}