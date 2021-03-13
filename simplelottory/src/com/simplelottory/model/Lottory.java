package com.simplelottory.model;

import java.util.ArrayList;
import java.util.List;

import com.simplelottory.control.LottoryDraw;
import com.simplelottory.excpetion.DrawFinishException;
import com.simplelottory.excpetion.MaxLimitException;

public abstract class Lottory {
	private List<Pool> pools;
	private LottoryDraw draw = new LottoryDraw() {
		@Override
		public int draw(List<Pool> pools) {
			System.out.println("default draw test");
			int draw = -1;
			for (Pool pool : pools) {
				try {
					draw = pool.draw();
					break;
				} catch (MaxLimitException ex) {
					System.out.println(ex.getMessage());
				}
			}
			if (draw == -1) {
				new DrawFinishException();
			}
			return draw;
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

	public int draw() {
		return this.draw.draw(this.pools);
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
		return this.getPool().getOriginNumbers();
	}
	
	public void testPrint() {
		for(Pool pool:this.pools) {
			pool.getSelectedNumbers() .forEach(x-> System.out.print(" "+x));
			System.out.println();
		}
	}
}
