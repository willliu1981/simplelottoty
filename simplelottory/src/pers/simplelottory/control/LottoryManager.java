package pers.simplelottory.control;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pers.simplelottory.control.excpetion.DrawFinishException;
import pers.simplelottory.model.Lottory;
import pers.simplelottory.model.Lottory.LottoryType;

public class LottoryManager {
	protected Map<String, Lottory> mapLottory;// Map<define name , class type Lottory>

	public LottoryManager() {
		mapLottory = new HashMap<>();
	}

	public void addLottory(Lottory lottory, String name) {
		this.mapLottory.put(name, lottory);
	}

	public void addLottory(Lottory lottory, LottoryType type) {
		this.addLottory(lottory, type.getDefineName());
	}

	public void shuffle(String name) {
		this.getLottory(name).shuffle();
	}

	public void shuffle(LottoryType type) {
		this.shuffle(type.getDefineName());
	}

	public void shuffleAll() {
		this.mapLottory.values().forEach(x -> x.shuffle());
	}

	public int drawOnce(LottoryType type) throws DrawFinishException {
		return this.getLottory(type).draw();
	}

	public Lottory draw(LottoryType type) {
		while (true) {
			int draw = -1;
			try {
				draw = this.drawOnce(type);
			} catch (DrawFinishException ex) {
				System.out.println(ex.getMessage());
				break;
			}
		}
		return this.getLottory(type);
	}

	public void drawAll() {
		Set<String> sets = this.mapLottory.keySet();
		Iterator<String> it = sets.iterator();
		while (it.hasNext()) {
			String name=it.next();
			this.draw(LottoryType.findByDefinename(name));
		}
	}

	public Lottory getLottory(String name) {
		return this.mapLottory.get(name);
	}

	public Lottory getLottory(LottoryType type) {
		return this.getLottory(type.getDefineName());
	}

	public void reset(LottoryType type) {
		this.getLottory(type).reset();
		this.shuffle(type);
	}

	public void resetAll() {
		this.mapLottory.values().forEach(Lottory::reset);
		this.shuffleAll();
	}

	public void showDrewLottoryInfo(LottoryType type) {
		System.out.println(this.getLottory(type).getPrimalInfo());
	}

	public void showDrewLottorySortedInfo(LottoryType type) {
		System.out.println(this.getLottory(type).getSortedInfo());
	}

	public List<Integer> getDrewNumbers(LottoryType type, int pool_index) {
		return this.getLottory(type).getDrewNumbers(pool_index);
	}
}
