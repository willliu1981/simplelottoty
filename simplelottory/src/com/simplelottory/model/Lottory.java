package com.simplelottory.model;

import java.util.List;

public abstract class Lottory {
	private Pool main_pool;

	public Lottory(Pool pool) {
		this.main_pool = pool;
	}

	public int getMaxNumber() {
		return this.main_pool.getNumbersSize();
	}

	public int draw() {

		return 0;
	}

	public void shufflt() {
		this.main_pool.shufflt();
	}
	
	public Pool getMainPool() {
		return this.main_pool;
	}
	
	public List<Integer> getMainPoolNumbers(){
		return this.getMainPool().getNumbers();
	}
}
