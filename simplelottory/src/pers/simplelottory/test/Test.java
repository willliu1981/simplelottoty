package pers.simplelottory.test;

import pers.simplelottory.control.LottoryManager;
import pers.simplelottory.control.strategy.BigLottoDraw;
import pers.simplelottory.main.SimpleLottory;
import pers.simplelottory.model.Lottory;
import pers.simplelottory.model.Lottory.LottoryType;
import pers.simplelottory.model.Pool;

public class Test {

	public static void main(String[] args) {
		SimpleLottory app = new SimpleLottory();
		Lottory bigLotto = new Lottory(LottoryType.BigLotto,new BigLottoDraw(), new Pool(49, 6), new Pool(1));
		Lottory lotto539 = new Lottory(LottoryType.Lotto539,new Pool(39, 5));
		Lottory superlotto = new Lottory(LottoryType.SuperLotto,new Pool(38, 6), new Pool(8, 1));
		app.manager.addLottory(bigLotto, LottoryType.BigLotto);
		app.manager.addLottory(lotto539, LottoryType.Lotto539);
		app.manager.addLottory(superlotto, LottoryType.SuperLotto);

		// original order
		app.manager.getLottory(LottoryType.BigLotto).getDefaultPoolOriginNumbers().stream()
				.forEach(x -> System.out.print(" " + x));

		// shuffle order
		app.manager.shuffle(LottoryType.BigLotto);
		app.manager.shuffle(LottoryType.Lotto539);
		app.manager.shuffle(LottoryType.SuperLotto);
		System.out.println();
		app.manager.getLottory(LottoryType.BigLotto).getDefaultPoolOriginNumbers().stream()
				.forEach(x -> System.out.print(" " + x));
		// draw
		System.out.println();
		// app.manager.draw(LottoryType.Lotto539);
//		app.manager.draw(LottoryType.BigLotto);
//		app.manager.draw(LottoryType.BigLotto);
//		app.manager.draw(LottoryType.BigLotto);
//		app.manager.draw(LottoryType.BigLotto);
//		app.manager.draw(LottoryType.BigLotto);
//		app.manager.draw(LottoryType.BigLotto);
//		System.out.println();
//		app.manager.draw(LottoryType.BigLotto);
//		System.out.println();
//		app.manager.draw(LottoryType.BigLotto);
//		app.manager.draw(LottoryType.BigLotto);
//		app.manager.draw(LottoryType.BigLotto);
		app.manager.draw(LottoryType.Lotto539);
		app.manager.getLottory(LottoryType.Lotto539).testPrint();
	}

}
