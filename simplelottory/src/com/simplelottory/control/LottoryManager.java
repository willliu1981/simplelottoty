package com.simplelottory.control;

import java.util.HashMap;
import java.util.Map;

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
		this.lottos.get(name).shuffle();
	}

	public void shuffle(LottoryType type) {
		this.shuffle(type.getType());
	}

	public int draw(LottoryType type) {
		return this.lottos.get(type.getType()).draw();
	}

	public Lottory getLottory(String name) {
		return this.lottos.get(name);
	}

	public Lottory getLottory(LottoryType type) {
		return this.getLottory(type.getType());
	}
}
