package com.simplelottory.model;

import java.util.ArrayList;
import java.util.List;

import com.simplelottory.control.LottoryDraw;
import com.simplelottory.excpetion.DrawFinishException;
import com.simplelottory.excpetion.MaxLimitException;

public class Lottory {
	private List<Pool> pools;
	private LottoryDraw draw = new LottoryDraw() {
		@Override
		public int draw(List<Pool> pools) {
			return this.default_draw(pools);
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
		return this.pools.get(index).getOriginNumbersSize();
	}

	public void SetLottoryDraw(LottoryDraw draw) {
		this.draw = draw;
	}

	public int draw() throws DrawFinishException {
		int draw = -1;
		draw = this.draw.draw(this.pools);
		return draw;
	}

	public void shuffle() {
		for (Pool pool : this.pools) {
			pool.shuffle();
		}
	}

	public Pool getPool() {
		return this.getPool(0);
	}

	public Pool getPool(int index) {
		return this.pools.get(index);
	}

	public List<Integer> getMainPoolNumbers() {
		return this.getPool().getOriginNumbers();
	}

	public void testPrint() {
		for (Pool pool : this.pools) {
			pool.getDrewNumbers().forEach(x -> System.out.print(" " + x));
			System.out.println();
		}
	}
}
