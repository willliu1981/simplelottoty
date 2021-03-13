package com.simplelottory.control;

import java.util.List;

import com.simplelottory.excpetion.DrawFinishException;
import com.simplelottory.excpetion.MaxLimitException;
import com.simplelottory.model.Pool;

public class BigLottoDraw extends LottoryDraw {

	@Override
	public int draw(List<Pool> pools) {
		System.out.println("test draw:biglotto");
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

}
