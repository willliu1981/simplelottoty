package pers.simplelottory.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import pers.simplelottory.control.excpetion.EndOfLottoryListException;
import pers.simplelottory.model.Lottory;
import pers.simplelottory.model.Pool;
import pers.simplelottory.model.Lottory.LottoryType;

public class CustomerLottory {
	protected List<Lottory> lottories;
	protected Map<Lottory, Lottory> mapMatchedResult;// Map<this drew lottory,matched lottory result>
	protected Integer lottory_period;
	protected int pointer = 0;

	public CustomerLottory(int period) {
		lottories = new ArrayList<>();
		mapMatchedResult = new HashMap<>();
	}

	public int getPointer() {
		return this.pointer;
	}

	public void add(Lottory lottory) {
		this.lottories.add(lottory);
	}

	public boolean next() {
		this.pointer++;
		return this.pointer < this.lottories.size();
	}

	public Lottory get() {
		if (this.pointer >= this.lottories.size()) {
			throw new EndOfLottoryListException(this.pointer);
		}
		return this.lottories.get(pointer);
	}

	public List<Lottory> getLottories() {
		return this.lottories;
	}

	public void reset() {
		this.lottories.clear();
		this.pointer = 0;
	}

	public void addInToMatchedResultMap(Lottory origin, Lottory result) {
		this.mapMatchedResult.put(origin, result);
	}

	public Lottory getLottoryFromMatchedResultMap(Lottory lottory) {
		return this.mapMatchedResult.get(lottory);
	}

	public void match(Lottory master) {
		this.lottories.forEach(x -> {
			List<Pool> match_result = x.match(master);
			Pool[] pools = new Pool[match_result.size()];
			match_result.toArray(pools);
			Lottory lottory = App.createDefaultLottory(x.getType());
			lottory.setPools(pools);
			lottory.setId(x.getId());
			int sum = 0;
			for (int i = 0; i < match_result.size(); i++) {
				sum += match_result.get(i).getDrewNumbersSize();
			}
			lottory.setTag(lottory.getTag() + " matchs:" + sum);
			this.mapMatchedResult.put(x, lottory);
		});
	}

	public void testShowResults() {
		this.mapMatchedResult.keySet().stream().filter(x -> {
			String[] tags = this.mapMatchedResult.get(x).getTag().split(" ");
			Optional<String> kvOp = Arrays.asList(tags).stream().filter(x2 -> {
				String[] kv = x2.split(":");
				return kv[0].equalsIgnoreCase("matchs");
			}).findFirst();
			int sum = 0;
			if (kvOp.isPresent()) {
				try {
					sum = Integer.valueOf(kvOp.get().split(":")[1]);
				} catch (NumberFormatException ex) {
					sum = 0;
				}
			}
			return sum >= 1;
		}).forEach(x -> {
			System.out.format("%s  ---- > ", x.getSortedInfo());
			System.out.format("%s \n", this.mapMatchedResult.get(x).getSortedInfo());
		});
	}

}
