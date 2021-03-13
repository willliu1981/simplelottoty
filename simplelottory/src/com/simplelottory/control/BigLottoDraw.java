package com.simplelottory.control;

import java.util.List;

import com.simplelottory.model.Pool;

public class BigLottoDraw extends LottoryDraw {

	@Override
	public int draw(List<Pool> pools) {
		System.out.println("test draw:biglotto");
		Pools.setSameOriginNumbers(pools.get(1), pools.get(0));
		int draw = this.default_draw(pools);
		return draw;
	}

}
