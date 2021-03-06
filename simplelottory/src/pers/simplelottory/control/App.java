package pers.simplelottory.control;

import pers.simplelottory.control.strategy.BigLottoDraw;
import pers.simplelottory.model.Lottory;
import pers.simplelottory.model.Lottory.LottoryType;
import pers.simplelottory.model.Pool;

public class App {
	public static LottoryManager createDefaultMasterManager() {
		LottoryManager master_manager = new LottoryManager();

		master_manager.addLottory(createDefaultLottory(LottoryType.BigLotto), LottoryType.BigLotto);
		master_manager.addLottory(createDefaultLottory(LottoryType.Lotto539), LottoryType.Lotto539);
		master_manager.addLottory(createDefaultLottory(LottoryType.SuperLotto), LottoryType.SuperLotto);
		master_manager.addLottory(createDefaultLottory(LottoryType.Lotto24half), LottoryType.Lotto24half);
		master_manager.addLottory(createDefaultLottory(LottoryType.Bingo), LottoryType.Bingo);
		return master_manager;
	}

	public static Lottory createDefaultLottory(LottoryType type) {
		Lottory lottory = null;
		switch (type) {
		case BigLotto:
			lottory = new Lottory(type, new BigLottoDraw(), new Pool(49, 6), new Pool(1)) {
				@Override
				protected String getDefaultInfo(boolean sort) {
					StringBuilder sb = new StringBuilder();
					this.getDrewNumbers(1).forEach(x -> sb.append(" " + x));
					return super.getDefaultInfo(sort) + "    special number:" + sb.toString();
				}
			};
			break;
		case Lotto539:
			lottory = new Lottory(type, new Pool(39, 5));
			break;
		case SuperLotto:
			lottory = new Lottory(type, new Pool(38, 6), new Pool(8, 1)) {
				@Override
				protected String getDefaultInfo(boolean sort) {
					StringBuilder sb = new StringBuilder();
					this.getDrewNumbers(1).forEach(x -> sb.append(" " + x));
					return super.getDefaultInfo(sort) + "    Second Area number:" + sb.toString();
				}
			};
			break;
		case Lotto24half:
			lottory = new Lottory(type, new Pool(24, 12));
			break;
		case Bingo:
			lottory = new Lottory(type, new Pool(80, 20));
			break;
		}
		return lottory;
	}
}
