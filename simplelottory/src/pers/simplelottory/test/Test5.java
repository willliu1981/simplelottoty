package pers.simplelottory.test;

import pers.simplelottory.control.BigLottoDraw;
import pers.simplelottory.control.CustomerLottoryManager;
import pers.simplelottory.control.LottoryManager.LottoryType;
import pers.simplelottory.model.Lottory;
import pers.simplelottory.model.Pool;

public class Test5 {

	public static void main(String[] args) {

		CustomerLottoryManager manager = new CustomerLottoryManager();
		manager.addLottory(new Lottory(new BigLottoDraw(), new Pool(49, 6), new Pool(1)) {
			@Override
			public String getPrimalInfo() {
				StringBuilder sb = new StringBuilder();
				this.getDrewNumbers(1).forEach(x -> sb.append(" " + x));
				return super.getPrimalInfo() + "    special number:" + sb.toString();
			}
		}, LottoryType.BigLotto);
		Lottory lottory = manager.createNewLottory(LottoryType.BigLotto);
		System.out.println(lottory.getPrimalInfo());

	}

}
