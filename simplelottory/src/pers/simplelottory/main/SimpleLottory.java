package pers.simplelottory.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import pers.simplelottory.control.App;
import pers.simplelottory.control.BigLottoDraw;
import pers.simplelottory.control.LottoryManager;
import pers.simplelottory.model.Lottory;
import pers.simplelottory.model.Lottory.LottoryType;
import pers.simplelottory.model.Pool;

/*
 * main class
 */
public class SimpleLottory {

	public static LottoryManager manager ;

	public static void main(String s[]) {
		init();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String read;
		System.out.println("App start...");
		tip();
		try {
			while (true) {
				read = br.readLine();
				/*
				 * if illegal
				 */
				if (read == null || !LottoryType.containsValue(read)) {
					System.out.println("Illegal inputs");
					continue;
				}

				/*
				 * process draw
				 */
				LottoryType type;
				System.out.println((type = LottoryType.find(read)) + ": process info[");
				manager.draw(type);
				System.out.print("]\nResult:\n" + type + "=   ");
				manager.showDrewLottoryInfo(type);
				System.out.print("Sorted=  ");
				manager.showDrewLottorySortedInfo(type);

				System.out.println("\nContinue Y/N?\n: ");
				if (!askContinue(br, type)) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void init() {
		manager=App.createDefaultMasterManager();
		manager.shuffleAll();
	}

	public static void tip() {
		StringBuilder sb = new StringBuilder();
		sb.append(LottoryType.BigLotto.getValue() + "=" + LottoryType.BigLotto + " ");
		sb.append(LottoryType.SuperLotto.getValue() + "=" + LottoryType.SuperLotto + " ");
		sb.append(LottoryType.Lotto539.getValue() + "=" + LottoryType.Lotto539 + " ");
		sb.append(LottoryType.Lotto24half.getValue() + "=" + LottoryType.Lotto24half + " ");
		sb.append(LottoryType.Bingo.getValue() + "=" + LottoryType.Bingo + " ");
		System.out.println(sb);
	}

	public static boolean askContinue(BufferedReader br, LottoryType type) throws IOException {
		boolean r = true;
		String read;
		while (true) {
			read = br.readLine();
			/*
			 * if illegal
			 */
			if (read == null || (!read.equalsIgnoreCase("y") && !read.equalsIgnoreCase("n"))) {
				System.out.println("Illegal inputs");
				continue;
			}

			if (read.equalsIgnoreCase("y")) {
				tip();
				manager.reset(type);
				break;
			} else if (read.equalsIgnoreCase("n")) {
				System.out.println("Goodbye");
				r = false;
				break;
			}
		}
		return r;
	}
}
