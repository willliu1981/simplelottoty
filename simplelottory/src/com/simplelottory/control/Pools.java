package com.simplelottory.control;

import com.simplelottory.model.Pool;

public class Pools {
	public static boolean setSameOriginNumbers(Pool this_pool, Pool other_pool) {
		boolean r = false;
		if (this_pool.getOriginNumbers() != other_pool.getOriginNumbers()) {
			this_pool.setOriginNumber(other_pool.getOriginNumbers());
			r = true;
		}
		return r;
	}
}
