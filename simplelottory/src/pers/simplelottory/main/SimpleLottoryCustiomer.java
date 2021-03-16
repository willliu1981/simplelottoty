package pers.simplelottory.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import pers.simplelottory.control.App;
import pers.simplelottory.control.CustomerLottoryManager;
import pers.simplelottory.control.Outputs;
import pers.simplelottory.model.Lottory;
import pers.simplelottory.model.Lottory.LottoryType;

public class SimpleLottoryCustiomer {

	public static CustomerLottoryManager customer_manager;

	public static void main(String[] args) {
		init();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("App SimpleLottoryCsutomer start...");
		try {
			while (true) {
				System.out.println(Outputs.tip());
				LottoryType type = askType(br);

				int num = askCreateQuantity(br);
				List<Lottory> list = customer_manager.createNewCustomerLottoriesForNumber(num, type);
				System.out.format("%s Add this:\n", type);
				System.out.println(Outputs.foreach(list, 10));

				if (askCreateOther(br)) {
					continue;
				}

				customer_manager.match();
				System.out.println("");
				System.out.println("Master numbers:");
				customer_manager.testShowMaster();
				System.out.println("");
				System.out.println("Customer numbers:");
				customer_manager.testShowResults();
				matchDrawResult(br);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void init() {
		customer_manager = new CustomerLottoryManager(App.createDefaultMasterManager());
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
		return LottoryType.findByValue(read);
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
		String read;
		while (true) {
			read = br.readLine().trim();
			if (read.equalsIgnoreCase("y")) {
				return true;
			} else if (read.equalsIgnoreCase("n")) {
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
