package pers.simplelottory.control;

import pers.simplelottory.model.Lottory;
import pers.simplelottory.model.Pool;

public class Lottories {
	/*
	 * Get draw numbers from origin lottory and add in them to new lottory
	 */
	public static Lottory simpleCopy(Lottory origin) {
		Lottory lottory;
		Pool[] pools = new Pool[origin.getPoolSize()];
		for (int i = 0; i < origin.getPoolSize(); i++) {
			Pool pool = new Pool(0);
			origin.getDrewNumbers(i).stream().forEach(x -> pool.getDrewNumbers().add(x));
			pools[i] = pool;
		}
		lottory = new Lottory(origin.getType(), pools);
		return lottory;
	}

	public static void match(Lottory origin, Lottory result) {

	}
}
