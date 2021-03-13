package com.simplelottory.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.simplelottory.control.LottoryManager.LottoryType;
import com.simplelottory.model.Lottory;
import com.simplelottory.model.Pool;

/*
 * main class
 */
public class SimpleLottory {
	public static final String Type_BigLotto = "1";
	public static final String Type_SuperLotto = "2";
	public static final String Type_Lotto539 = "3";
	public static final Map<String, LottoryType> lottory_type_map = new HashMap<>();
	static {
		lottory_type_map.put(Type_BigLotto, LottoryType.BigLotto);
		lottory_type_map.put(Type_SuperLotto, LottoryType.SuperLotto);
		lottory_type_map.put(Type_Lotto539, LottoryType.Lotto539);
	}

	public static LottoryManager manager = new LottoryManager();

	public static void main(String s[]) {
		init();
		/*
		 * manager.draw(LottoryType.BigLotto);
		 * System.out.println(manager.getLottory(LottoryType.BigLotto).getDrewNumbers(0)
		 * );
		 * System.out.println(manager.getLottory(LottoryType.BigLotto).getDrewNumbers(1)
		 * );
		 *///

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String read;
		System.out.println("App start...");
		tip();
		try {
			while ((read = br.readLine()) != null) {
				LottoryType type;
				System.out.println(type = lottory_type_map.get(read));
				manager.draw(type);
				System.out.print(type + ":\t");
				manager.showDrewLottoryInfo(type);
				System.out.println("\nContinue Y/N?\n: ");
				read = br.readLine();
				if (read.equalsIgnoreCase("y")) {
					tip();
				} else if (read.equalsIgnoreCase("n")) {
					System.out.println("Goodbye");
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void init() {
		Lottory bigLotto = new Lottory(new BigLottoDraw(), new Pool(49, 6), new Pool(1)) {
			@Override
			public String getInfo() {
				StringBuilder sb = new StringBuilder();
				this.getPool(1).getDrewNumbers().forEach(x -> sb.append(" " + x));
				return super.getInfo() + "\tpecial number:" + sb.toString();
			}
		};
		Lottory lotto539 = new Lottory(new Pool(39, 5));
		Lottory superlotto = new Lottory(new Pool(38, 6), new Pool(8, 1)) {
			@Override
			public String getInfo() {
				StringBuilder sb = new StringBuilder();
				this.getPool(1).getDrewNumbers().forEach(x -> sb.append(" " + x));
				return super.getInfo() + "\tSec.Area number:" + sb.toString();
			}
		};
		manager.addLottory(LottoryType.BigLotto, bigLotto);
		manager.addLottory(LottoryType.Lotto539, lotto539);
		manager.addLottory(LottoryType.SuperLotto, superlotto);
		manager.shuffleAll();
	}

	public static void tip() {
		System.out.format("Choose Lottory %s=BigLotto %s=SuperLotto %s=Lotto539\n: ", Type_BigLotto, Type_SuperLotto,
				Type_Lotto539);
	}
}
