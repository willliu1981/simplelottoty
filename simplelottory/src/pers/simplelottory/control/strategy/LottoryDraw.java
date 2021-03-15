package pers.simplelottory.control.strategy;

import java.util.List;

import pers.simplelottory.control.excpetion.DrawFinishException;
import pers.simplelottory.control.excpetion.MaxLimitException;
import pers.simplelottory.model.Pool;

public abstract class LottoryDraw {
	public int default_draw(List<Pool> pools) {
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
