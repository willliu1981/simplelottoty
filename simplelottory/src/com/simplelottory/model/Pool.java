package com.simplelottory.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.simplelottory.excpetion.MaxLimitException;

public class Pool {
	private List<Integer> origin_numbers;
	private List<Integer> drew_numbers;
	private int selected_max_limit;

	public Pool(int max_count, int selected_max_limit) {
		this.origin_numbers = new ArrayList<>();
		this.drew_numbers = new ArrayList<>();
		this.selected_max_limit = selected_max_limit;
		this.createPool(max_count);
	}

	public Pool(Pool pool, int selected_max_limit) {
		this(0, selected_max_limit);
		this.origin_numbers = pool.getOriginNumbers();
	}

	private void createPool(int max_count) {
		for (int i = 1; i <= max_count; i++) {
			origin_numbers.add(i);
		}
	}

	public int getOriginNumbersSize() {
		return this.origin_numbers.size();
	}

	public int getSelectedNumbersSize() {
		return this.origin_numbers.size();
	}

	public List<Integer> getOriginNumbers() {
		return this.origin_numbers;
	}

	public List<Integer> getDrewNumbers() {
		return this.drew_numbers;
	}

	public void shuffle() {
		Collections.shuffle(origin_numbers);
	}

	public int draw() {
		System.out.println("Pool draw test");
		if (this.drew_numbers.size() >= this.selected_max_limit) {
			throw new MaxLimitException(this.drew_numbers.size());
		}
		int draw;
		this.drew_numbers.add(draw = this.origin_numbers.remove(0));
		return draw;
	}

	public void reset() {
		this.origin_numbers.addAll(this.drew_numbers);
		this.drew_numbers.clear();
	}
}
