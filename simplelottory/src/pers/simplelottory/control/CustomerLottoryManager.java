package pers.simplelottory.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pers.simplelottory.model.Lottory;
import pers.simplelottory.model.Lottory.LottoryType;

public class CustomerLottoryManager {
	protected LottoryManager master_manager;
	protected Map<String, CustomerLottory> mapCustomerLottory;// map<define name, class type List<Lottory>>
	protected static Integer period = 0;

	public CustomerLottoryManager() {
		master_manager = new LottoryManager();
		this.mapCustomerLottory = new HashMap<>();
	}

	public CustomerLottoryManager(LottoryManager master_manager) {
		this();
		this.master_manager = master_manager;
	}

	public void addMasterLottory(Lottory lottory, LottoryType type) {
		this.master_manager.addLottory(lottory, type);
	}

	public void addLottory(Lottory lottory, LottoryType type) {
		this.getCustomerLottory(type).add(lottory);
	}

	protected CustomerLottory getCustomerLottory(LottoryType type) {
		CustomerLottory cl = null;
		if (this.mapCustomerLottory.containsKey(type.getDefineName())) {
			cl = this.mapCustomerLottory.get(type.getDefineName());
		} else {
			cl = new CustomerLottory(period);
			this.mapCustomerLottory.put(type.getDefineName(), cl);
		}
		return cl;
	}

	public Lottory getLottory(LottoryType type) {
		System.out.println("eeee");
		Lottory lottory = null;
		if (this.getCustomerLottory(type).next()) {
			lottory = this.getCustomerLottory(type).get();
		}
		return lottory;
	}

	public Lottory createNewCustomerLottory(LottoryType type) {
		this.master_manager.reset(type);
		Lottory draw = Lottories.simpleCopy(this.master_manager.draw(type));
		this.addLottory(draw, type);
		return draw;
	}

	public List<Lottory> createNewCustomerLottoriesForNumber(int number, LottoryType type) {
		List<Lottory> temp = new ArrayList<>();
		for (int i = 1; i <= number; i++) {
			temp.add(this.createNewCustomerLottory(type));
		}
		return temp;
	}

	public void match() {
		this.master_manager.resetAll();
		this.master_manager.drawAll();
		this.mapCustomerLottory.keySet().forEach(x -> {
			this.mapCustomerLottory.get(x).match(this.master_manager.getLottory(x));
		});
	}

	public List<Lottory> getLottories(LottoryType type) {
		return this.getCustomerLottory(type).getLottories();
	}

	public void reset(LottoryType type) {
		this.getCustomerLottory(type).reset();
	}

	public void resetAll() {
		this.mapCustomerLottory.clear();
	}

	public void testShowResults() {
		this.mapCustomerLottory.keySet().stream().forEach(x -> {
			System.out.println(LottoryType.findByDefinename(x) + ":  Master numbers "
					+ this.master_manager.getLottory(LottoryType.findByDefinename(x)).getSortedInfo());
			this.mapCustomerLottory.get(x).testShowResults();
			System.out.println();
		});
	}

	public void testShowMaster() {
		this.master_manager.testShowDrewInfo();
	}

	public LottoryManager getMasterLottoryManager() {
		return this.master_manager;
	}

}
