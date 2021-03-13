package com.simplelottory.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.simplelottory.excpetion.DrawFinishException;
import com.simplelottory.model.Lottory;

public class LottoryManager {
	private Map<String, Lottory> lottos;

	public enum LottoryType {
		BigLotto("BigLotto"), SuperLotto("SuperLotto"), Lotto539("Lotto539"), Lotto24("Lotto24"),
		BingoBingo("BingoBingo");

		private String type;

		LottoryType(String type) {
			this.type = type;
		}

		public String getType() {
			return this.type;
		}

		public String toString() {
			return this.type;
		}
	}

	public LottoryManager() {
		lottos = new HashMap<>();
	}

	public void addLottory(String name, Lottory lottory) {
		this.lottos.put(name, lottory);
	}

	public void addLottory(LottoryType type, Lottory lottory) {
		this.addLottory(type.getType(), lottory);
	}

	public void shuffle(String name) {
		this.getLottory(name).shuffle();
	}

	public void shuffle(LottoryType type) {
		this.shuffle(type.getType());
	}

	public void shuffleAll() {
		this.lottos.values().forEach(x -> x.shuffle());
	}

	public int drawOnce(LottoryType type) throws DrawFinishException {
		return this.getLottory(type).draw();
	}

	public void draw(LottoryType type) {
		while (true) {
			int draw = -1;
			try {
				draw = this.drawOnce(type);
			} catch (DrawFinishException ex) {
				System.out.println(ex.getMessage());
				break;
			}
		}
	}

	public Lottory getLottory(String name) {
		return this.lottos.get(name);
	}

	public Lottory getLottory(LottoryType type) {
		return this.getLottory(type.getType());
	}

	public void reset(LottoryType type) {
		this.getLottory(type).reset();
		this.shuffle(type);
	}

	public void resetAll() {
		this.lottos.values().forEach(Lottory::reset);
		this.shuffleAll();
	}

	public void showDrewLottoryInfo(LottoryType type) {
		System.out.println(this.getLottory(type).getPrimalInfo());
	}

	public void showDrewSortedLottoryInfo(LottoryType type) {
		System.out.println(this.getLottory(type).getSortedInfo());
	}

	public List<Integer> getDrewNumbers(LottoryType type, int pool_index) {
		return this.getLottory(type).getDrewNumbers(pool_index);
	}
}
