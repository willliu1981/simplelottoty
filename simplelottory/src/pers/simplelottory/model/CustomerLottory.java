package pers.simplelottory.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pers.simplelottory.control.excpetion.EndOfLottoryListException;

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

	public void addMatchedResult(Lottory drew_lottory, Lottory result) {
		this.mapResults.put(drew_lottory, result);
	}

	public Lottory getMatchedResult(Lottory lottory) {
		return this.mapResults.get(lottory);
	}

}
