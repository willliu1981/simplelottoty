package com.simplelottory.control;

import java.util.List;

import com.simplelottory.model.Pool;

public class BigLottoDraw extends LottoryDraw {

	@Override
	public int draw(List<Pool> pools) {
		System.out.println("test draw:biglotto");
		
		int draw = this.default_draw(pools);
		return draw;
	}

}
