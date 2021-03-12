package com.simplelottory.control;

import com.simplelottory.model.Lottory;
import com.simplelottory.model.Pool;

public class SimpleLottory {
	public static final String Lottory_BigLotto = "biglotto";

	private LottoryManager manager = new LottoryManager();

	public static void main(String s[]) {
		SimpleLottory app = new SimpleLottory();

		Lottory bigLotto = new Lottory(new Pool(49, 6)) {
		};
		app.manager.addLottory(Lottory_BigLotto, bigLotto);

		app.manager.getLottory(Lottory_BigLotto).getMainPoolNumbers().stream().forEach(x -> System.out.print(" " + x));

		app.manager.shufflt(Lottory_BigLotto);

		System.out.println();
		app.manager.getLottory(Lottory_BigLotto).getMainPoolNumbers().stream().forEach(x -> System.out.print(" " + x));
		// System.out.println(bigLotto.getMaxNumber());
	}
}
