package pers.simplelottory.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pers.simplelottory.control.excpetion.EndOfLottoryListException;
import pers.simplelottory.model.Lottory;

public class CustomerLottory {
	protected List<Lottory> lottories;
	protected Map<Lottory, Lottory> mapResults;// Map<this drew lottory,matched lottory result>
	protected Integer lottory_period;
	protected int pointer = 0;

	public CustomerLottory(int period) {
		lottories = new ArrayList<>();
		mapResults = new HashMap<>();
	}

	public int getPointer() {
		return this.pointer;
	}

	public void add(Lottory lottory) {
		this.lottories.add(lottory);
	}

	public boolean next() {
		this.pointer++;
		return this.pointer < this.lottories.size();
	}

	public Lottory get() {
		if (this.pointer >= this.lottories.size()) {
			throw new EndOfLottoryListException(this.pointer);
		}
		return this.lottories.get(pointer);
	}

	public List<Lottory> getLottories() {
		return this.lottories;
	}

	public void reset() {
		this.lottories.clear();
		this.pointer = 0;
	}

	public void addInToMatchedResultMap(Lottory origin, Lottory result) {
		this.mapResults.put(origin, result);
	}

	public Lottory getLottoryFromMatchedResultMap(Lottory lottory) {
		return this.mapResults.get(lottory);
	}

	public void match(Lottory master) {
		this.lottories.forEach(x -> {
			x.match(master);
		});
	}

}