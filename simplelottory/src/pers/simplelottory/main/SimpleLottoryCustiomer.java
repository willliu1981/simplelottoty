package pers.simplelottory.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import pers.simplelottory.control.BigLottoDraw;
import pers.simplelottory.control.CustomerLottoryManager;
import pers.simplelottory.control.Inputs;
import pers.simplelottory.control.LottoryManager;
import pers.simplelottory.control.LottoryManager.LottoryType;
import pers.simplelottory.model.Lottory;
import pers.simplelottory.model.Pool;

public class SimpleLottoryCustiomer {

	public static CustomerLottoryManager customer_manager;

	public static void main(String[] args) {
		init();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String read;
		System.out.println("App SimpleLottoryCsutomer start...");
		try {
			while (true) {
				System.out.println(Inputs.tip());
				LottoryType type = askType(br);
				int num = askCreateQuantity(br);
				List<Lottory> list = customer_manager.createNewCustomerLottoryForNumber(num, type);
				System.out.format("%s Add this:\n", type);
				list.forEach(System.out::println);
				if (askCreateOther(br)) {
					continue;
				}

				askCreateOther(br);

			}
		} catch (IOException e) {
			System.out.println("xxx");
			e.printStackTrace();
		}

	}

	private static void init() {
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

		customer_manager = new CustomerLottoryManager(master_manager);
	}

	private static LottoryType askType(BufferedReader br) throws IOException {
		String read = "";
		while (true) {
			read = br.readLine();
			/*
			 * if illegal
			 */
			if (read == null || !LottoryType.containsValue(read)) {
				System.out.println("Illegal inputs");
				continue;
			}
			break;
		}
		return LottoryType.find(read);
	}

	private static int askCreateQuantity(BufferedReader br) throws IOException {
		int num = 0;
		System.out.print("Quqntity:");
		while (true) {
			String read = br.readLine();
			/*
			 * if illegal
			 */
			if (read == null || read.isEmpty() || !isNumeric(read)) {
				continue;
			}
			num = Integer.parseInt(read);
			break;
		}
		return num;
	}

	private static boolean isNumeric(String data) {
		if (data == null) {
			return false;
		}
		try {
			Integer.parseInt(data.trim());
		} catch (NumberFormatException ex) {
			System.out.println("Illegal inputs");
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}

	private static boolean askCreateOther(BufferedReader br) throws IOException {
		System.out.println("Create other Y/N?");
		while (true) {
			if (br.readLine().trim().equalsIgnoreCase("y")) {
				return true;
			} else if (br.readLine().trim().equalsIgnoreCase("n")) {
				return false;
			} else {
				System.out.println("Illegal inputs");
				continue;
			}
		}
	}

	/*
	 * return result
	 */
	private static String matchDrawResult(BufferedReader br) {
		
		return null;
	}
}
