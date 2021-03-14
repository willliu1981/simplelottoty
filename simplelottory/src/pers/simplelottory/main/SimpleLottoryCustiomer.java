package pers.simplelottory.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import pers.simplelottory.control.Inputs;
import pers.simplelottory.control.LottoryManager;
import pers.simplelottory.control.LottoryManager.LottoryType;

public class SimpleLottoryCustiomer {

	public static LottoryManager master_manager = new LottoryManager();
	public static LottoryManager customer_manager = new LottoryManager();

	public static void main(String[] args) {
		init();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String read;
		System.out.println("App SimpleLottoryCsutomer start...");
		System.out.println(Inputs.tip());
		try {
			while (true) {
				read = br.readLine();
				int num = askCreateQuantity(br);
				System.out.println(""+num);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void init() {

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
				System.out.println("Illegal inputs");
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
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}
}
