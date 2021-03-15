package pers.simplelottory.test;

import pers.simplelottory.control.CustomerLottoryManager;
import pers.simplelottory.control.strategy.BigLottoDraw;
import pers.simplelottory.model.Lottory;
import pers.simplelottory.model.Lottory.LottoryType;
import pers.simplelottory.model.Pool;

public class Test5 {

	public static void main(String[] args) {
		LottoryType type = LottoryType.BigLotto;
		System.out.println(type);
		System.out.println(type.toString());

		CustomerLottoryManager manager = new CustomerLottoryManager();
		manager.addMasterLottory(new Lottory(LottoryType.BigLotto,new BigLottoDraw(), new Pool(49, 6), new Pool(1)) {
			@Override
			public String getPrimalInfo() {
				StringBuilder sb = new StringBuilder();
				this.getDrewNumbers(1).forEach(x -> sb.append(" " + x));
				return super.getPrimalInfo() + "    special number:" + sb.toString();
			}
		}, type);

		for (int i = 0; i < 10; i++) {
			Lottory lottory = manager.createNewCustomerLottory(type);
			System.out.println("info:" + lottory.getPrimalInfo());
		}
		System.out.println("show...");
		System.out.println("size:" + manager.getLottories(type).size());

		manager.getLottories(type).stream().forEach(System.out::println);
		manager.reset(type);
		System.out.println("reset...");
		manager.createNewCustomerLottory(type);
		manager.getLottories(type).stream().forEach(System.out::println);

	}

}
