package com.simplelottory.model;

import java.util.ArrayList;
import java.util.List;

import com.simplelottory.excpetion.MaxLimitException;

public abstract class Lottory {
	private List<Pool> pools;

	public Lottory(Pool... pools) {
		this.pools = new ArrayList<>();
		for (Pool pool : pools) {
			this.pools.add(pool);
		}
	}

	public int getMaxNumber() {
		return this.getMaxNumber(0);
	}

	public int getMaxNumber(int index) {
		return this.pools.get(index).getNumbersSize();
	}

	public int draw() {

		return 0;
	}

	public void shuffle() {
		this.shuffle(0);
	}

	public void shuffle(int index) {
		this.pools.get(index).shuffle();
	}

	public Pool getPool() {
		return this.getPool(0);
	}

	public Pool getPool(int index) {
		return this.pools.get(index);
	}

	public List<Integer> getMainPoolNumbers() {
		return this.getPool().getNumbers();
	}
}
