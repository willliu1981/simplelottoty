package com.simplelottory.control;

import java.util.List;

import com.simplelottory.model.Pool;

public abstract class LottoryDraw {
	public abstract int draw(List<Pool> pools);
}
