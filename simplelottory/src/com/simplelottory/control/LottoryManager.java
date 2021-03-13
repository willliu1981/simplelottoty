package com.simplelottory.control;

import java.util.HashMap;
import java.util.Map;

import com.simplelottory.excpetion.DrawFinishException;
import com.simplelottory.model.Lottory;

public class LottoryManager {
	private Map<String, Lottory> lottos;

	public enum LottoryType {
		BigLotto("biglotto"), SuperLotto("superlotto"), Lotto539("lotto539");

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
		this.lottos.get(type).reset();
	}

	public void resetAll() {
		this.lottos.values().forEach(Lottory::reset);
	}
}
