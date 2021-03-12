package com.simplelottory.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pool {
	private List<Integer> numbers;
	private int select_max_limit;

	public Pool(int count, int maxlimit) {
		this.numbers = new ArrayList<>();
		this.select_max_limit = maxlimit;
		this.createPool(count);
	}

	/*
	 * sdf
	 */
	private void createPool(int max) {
		for (int i = 1; i <= max; i++) {
			numbers.add(i);
		}
	}

	public int getNumbersSize() {
		return this.numbers.size();
	}

	public List<Integer> getNumbers() {
		return this.numbers;
	}
	
	public void shufflt() {
		Collections.shuffle(numbers);
	}
}
