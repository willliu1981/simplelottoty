package com.simplelottory.model;

import java.util.ArrayList;
import java.util.List;

import com.simplelottory.control.LottoryDraw;
import com.simplelottory.excpetion.MaxLimitException;

public abstract class Lottory {
	private List<Pool> pools;
	private LottoryDraw draw = new LottoryDraw() {
		@Override
		public int draw() {
			System.out.println("default draw test");
			return 0;
		}
	};

	public Lottory(Pool... pools) {
		this.pools = new ArrayList<>();
		for (Pool pool : pools) {
			this.pools.add(pool);
		}
	}

	public Lottory(LottoryDraw draw, Pool... pools) {
		this(pools);
		this.draw = draw;
	}

	public int getMaxNumber() {
		return this.getMaxNumber(0);
	}

	public int getMaxNumber(int index) {
		return this.pools.get(index).getNumbersSize();
	}

	public void SetLottoryDraw(LottoryDraw draw) {
		this.draw = draw;
	}

	public int draw() {
		this.pools.get(0).draw();
		this.draw.draw();
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
