package com.simplelottory.test;

import com.simplelottory.control.BigLottoDraw;
import com.simplelottory.control.LottoryManager;
import com.simplelottory.control.LottoryManager.LottoryType;
import com.simplelottory.control.SimpleLottory;
import com.simplelottory.model.Lottory;
import com.simplelottory.model.Pool;

public class Test {

	public static void main(String[] args) {
		SimpleLottory app = new SimpleLottory();

		Pool pool;
		Lottory bigLotto = new Lottory(new BigLottoDraw(), pool = new Pool(49, 6), new Pool(pool, 1)) {
		};
		Lottory lotto539 = new Lottory(new Pool(39, 5)) {
		};
		app.manager.addLottory(LottoryType.BigLotto, bigLotto);
		app.manager.addLottory(LottoryType.Lotto539, lotto539);

		// original order
		app.manager.getLottory(LottoryType.BigLotto).getMainPoolNumbers().stream()
				.forEach(x -> System.out.print(" " + x));

		// shuffle order
		app.manager.shuffle(LottoryType.BigLotto);
		System.out.println();
		app.manager.getLottory(LottoryType.BigLotto).getMainPoolNumbers().stream()
				.forEach(x -> System.out.print(" " + x));
		// draw
		System.out.println();
		// app.manager.draw(LottoryType.Lotto539);
		app.manager.draw(LottoryType.BigLotto);
		app.manager.draw(LottoryType.BigLotto);
		app.manager.draw(LottoryType.BigLotto);
		app.manager.draw(LottoryType.BigLotto);
		app.manager.draw(LottoryType.BigLotto);
		app.manager.draw(LottoryType.BigLotto);
		System.out.println();
		app.manager.draw(LottoryType.BigLotto);
		System.out.println();
		app.manager.draw(LottoryType.BigLotto);
		app.manager.draw(LottoryType.BigLotto);
		app.manager.draw(LottoryType.BigLotto);
		app.manager.draw(LottoryType.BigLotto);
		app.manager.getLottory(LottoryType.BigLotto).testPrint();
	}

}
