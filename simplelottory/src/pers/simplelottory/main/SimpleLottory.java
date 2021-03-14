package pers.simplelottory.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import pers.simplelottory.control.BigLottoDraw;
import pers.simplelottory.control.LottoryManager;
import pers.simplelottory.control.LottoryManager.LottoryType;
import pers.simplelottory.model.Lottory;
import pers.simplelottory.model.Pool;

/*
 * main class
 */
public class SimpleLottory {

	public static LottoryManager manager = new LottoryManager();

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
					System.out.println("Input is not legal");
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
				System.out.print("sort=  ");
				manager.showDrewSortedLottoryInfo(type);

				System.out.println("\nContinue Y/N?\n: ");
				if (!askContinue(br, type)) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void init() {
		Lottory bigLotto = new Lottory(new BigLottoDraw(), new Pool(49, 6), new Pool(1)) {
			@Override
			public String getPrimalInfo() {
				StringBuilder sb = new StringBuilder();
				this.getPool(1).getDrewNumbers().forEach(x -> sb.append(" " + x));
				return super.getPrimalInfo() + "    pecial number:" + sb.toString();
			}
		};
		Lottory lotto539 = new Lottory(new Pool(39, 5));
		Lottory superlotto = new Lottory(new Pool(38, 6), new Pool(8, 1)) {
			@Override
			public String getPrimalInfo() {
				StringBuilder sb = new StringBuilder();
				this.getPool(1).getDrewNumbers().forEach(x -> sb.append(" " + x));
				return super.getPrimalInfo() + "    Sec.Area number:" + sb.toString();
			}
		};
		Lottory lotto24half = new Lottory(new Pool(24, 12));
		Lottory bingo = new Lottory(new Pool(80, 20));
		manager.addLottory(bigLotto, LottoryType.BigLotto);
		manager.addLottory(lotto539, LottoryType.Lotto539);
		manager.addLottory(superlotto, LottoryType.SuperLotto);
		manager.addLottory(lotto24half, LottoryType.Lotto24half);
		manager.addLottory(bingo, LottoryType.Bingo);
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
				System.out.println("Input is not legal");
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
