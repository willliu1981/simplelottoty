package pers.simplelottory.control;

import pers.simplelottory.control.LottoryManager.LottoryType;
import pers.simplelottory.model.Lottory;
import pers.simplelottory.model.Pool;

public class App {
	public static LottoryManager createDefaultMasterManager() {
		LottoryManager master_manager = new LottoryManager();
		Lottory bigLotto = new Lottory(new BigLottoDraw(), new Pool(49, 6), new Pool(1)) {
			@Override
			public String getPrimalInfo() {
				StringBuilder sb = new StringBuilder();
				this.getDrewNumbers(1).forEach(x -> sb.append(" " + x));
				return super.getPrimalInfo() + "    special number:" + sb.toString();
			}
		};
		Lottory lotto539 = new Lottory(new Pool(39, 5));
		Lottory superlotto = new Lottory(new Pool(38, 6), new Pool(8, 1)) {
			@Override
			public String getPrimalInfo() {
				StringBuilder sb = new StringBuilder();
				this.getDrewNumbers(1).forEach(x -> sb.append(" " + x));
				return super.getPrimalInfo() + "    Second Area number:" + sb.toString();
			}
		};
		Lottory lotto24half = new Lottory(new Pool(24, 12));
		Lottory bingo = new Lottory(new Pool(80, 20));

		master_manager.addLottory(bigLotto, LottoryType.BigLotto);
		master_manager.addLottory(lotto539, LottoryType.Lotto539);
		master_manager.addLottory(superlotto, LottoryType.SuperLotto);
		master_manager.addLottory(lotto24half, LottoryType.Lotto24half);
		master_manager.addLottory(bingo, LottoryType.Bingo);
		return master_manager;
	}
}
