package pers.simplelottory.test;

import pers.simplelottory.control.BigLottoDraw;
import pers.simplelottory.control.CustomerLottoryManager;
import pers.simplelottory.control.LottoryManager.LottoryType;
import pers.simplelottory.model.Lottory;
import pers.simplelottory.model.Pool;

public class Test5 {

	public static void main(String[] args) {
		LottoryType type = LottoryType.BigLotto;
		System.out.println(type);
		System.out.println(type.toString());

		CustomerLottoryManager manager = new CustomerLottoryManager();
		manager.addMasterLottory(new Lottory(new BigLottoDraw(), new Pool(49, 6), new Pool(1)) {
			@Override
			public String getPrimalInfo() {
				StringBuilder sb = new StringBuilder();
				this.getDrewNumbers(1).forEach(x -> sb.append(" " + x));
				return super.getPrimalInfo() + "    special number:" + sb.toString();
			}
		}, LottoryType.BigLotto);

		for (int i = 0; i < 10; i++) {
			Lottory lottory = manager.createNewCustomerLottory(LottoryType.BigLotto);
			System.out.println("info:" + lottory.getPrimalInfo());
		}
		System.out.println("show...");
		System.out.println("size:" + manager.getLottories(LottoryType.BigLotto).size());

		manager.getLottories(LottoryType.BigLotto).forEach(System.out::println);

	}

}
