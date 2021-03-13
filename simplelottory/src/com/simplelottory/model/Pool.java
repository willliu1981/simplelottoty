package com.simplelottory.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.simplelottory.excpetion.MaxLimitException;

public class Pool {
	private List<Integer> origin_numbers;
	private List<Integer> selected_numbers;
	private int selected_max_limit;

	public Pool(int max_count, int selected_max_limit) {
		this.origin_numbers = new ArrayList<>();
		this.selected_numbers = new ArrayList<>();
		this.selected_max_limit = selected_max_limit;
		this.createPool(max_count);
	}

	private void createPool(int max_count) {
		for (int i = 1; i <= max_count; i++) {
			origin_numbers.add(i);
		}
	}

	public int getNumbersSize() {
		return this.origin_numbers.size();
	}

	public List<Integer> getNumbers() {
		return this.origin_numbers;
	}

	public void shuffle() {
		Collections.shuffle(origin_numbers);
	}

	public int draw() {
		if (this.selected_numbers.size() >= this.selected_max_limit) {
			throw new MaxLimitException(this.selected_numbers.size());
		}
		int draw;
		this.selected_numbers.add(draw = this.origin_numbers.remove(0));
		return draw;
	}

	public void reset() {
		this.origin_numbers.addAll(this.selected_numbers);
		this.selected_numbers.clear();
	}
}
