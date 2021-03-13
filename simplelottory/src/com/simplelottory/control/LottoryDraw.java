package com.simplelottory.control;

import java.util.List;

import com.simplelottory.excpetion.DrawFinishException;
import com.simplelottory.excpetion.MaxLimitException;
import com.simplelottory.model.Pool;

public abstract class LottoryDraw {
	public int default_draw(List<Pool> pools) {
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
			throw new DrawFinishException();
		}
		return draw;
	}
	public abstract int draw(List<Pool> pools);
}
