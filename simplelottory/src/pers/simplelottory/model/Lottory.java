package pers.simplelottory.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pers.simplelottory.control.LottoryDraw;
import pers.simplelottory.control.LottoryMatch;
import pers.simplelottory.control.excpetion.DrawFinishException;

public class Lottory {
	private List<Pool> pools;
	private LottoryDraw draw;
	private LottoryMatch match;
	private LottoryType type;

	public enum LottoryType {
		BigLotto("BigLotto", "1"), SuperLotto("SuperLotto", "2"), Lotto539("Lotto539", "3"),
		Lotto24half("Lotto24half", "4"), Bingo("BingoBingo", "5");

		private String defineName;
		private String value;

		LottoryType(String defineName, String value) {
			this.defineName = defineName;
			this.value = value;
		}

		public String getDefineName() {
			return this.defineName;
		}

		public String getValue() {
			return this.value;
		}

		public String toString() {
			return this.defineName;
		}

		public static LottoryType find(String value) {
			return Arrays.asList(LottoryType.values()).stream().filter(x -> x.value.equalsIgnoreCase(value)).findFirst()
					.get();
		}

		public static boolean containsValue(String value) {
			return Arrays.asList(LottoryType.values()).stream().filter(x -> x.value.equalsIgnoreCase(value)).findFirst()
					.isPresent();
		}
	}

	public Lottory(LottoryType type, Pool... pools) {
		this.pools = new ArrayList<>();
		for (Pool pool : pools) {
			this.pools.add(pool);
		}
		this.type = type;

		// create default draw
		draw = new LottoryDraw() {
			@Override
			public int draw(List<Pool> pools) {
				return this.default_draw(pools);
			}
		};

		// create default match
		match = new LottoryMatch() {
			@Override
			public int match(List<Pool> origin, List<Pool> matchTo) {
				return this.default_match(origin, matchTo);
			}
		};
	}

	public Lottory(LottoryType type, LottoryDraw draw, Pool... pools) {
		this(type, pools);
		// override default draw
		this.draw = draw;
	}

	public int getMaxNumber() {
		return this.getMaxNumber(0);
	}

	public int getMaxNumber(int index) {
		return this.pools.get(index).getOriginNumbersSize();
	}

	public void SetLottoryDraw(LottoryDraw draw) {
		this.draw = draw;
	}

	public int draw() throws DrawFinishException {
		int draw = -1;
		draw = this.draw.draw(this.pools);
		return draw;
	}

	public void shuffle() {
		for (Pool pool : this.pools) {
			pool.shuffle();
		}
	}

	public Pool getDefaultPool() {
		return this.getPool(0);
	}

	public Pool getPool(int index) {
		return this.pools.get(index);
	}

	public List<Integer> getDefaultPoolOriginNumbers() {
		return this.getOriginNumbers(0);
	}

	public List<Integer> getDefaultPoolDrewNumbers() {
		return this.getDrewNumbers(0);
	}

	public List<Integer> getOriginNumbers(int pool_index) {
		return this.pools.get(pool_index).getOriginNumbers();
	}

	public List<Integer> getDrewNumbers(int pool_index) {
		return this.getPool(pool_index).getDrewNumbers();
	}

	public void testPrint() {
		for (Pool pool : this.pools) {
			pool.getDrewNumbers().forEach(x -> System.out.print(" " + x));
			System.out.println();
		}
	}

	/*
	 * unsorted info
	 */
	public String getPrimalInfo() {
		return this.getDefaultInfo(false);
	}

	public String getSortedInfo() {
		return this.getDefaultInfo(true);
	}

	protected String getDefaultInfo(boolean sort) {
		StringBuilder sb = new StringBuilder();
		if (sort) {
			this.pools.stream().forEach(x -> {
				x.getDrewNumbers().stream().sorted().forEach(x2 -> sb.append(x2 + " "));
				sb.append("  ");
			});
		} else {
			this.pools.stream().forEach(x -> {
				x.getDrewNumbers().stream().forEach(x2 -> sb.append(x2 + " "));
				sb.append("  ");
			});
		}
		return sb.toString();
	}

	public void reset() {
		for (Pool pool : this.pools) {
			pool.reset();
		}
	}

	public int getPoolSize() {
		return this.pools.size();
	}

	public int getDrewSize(int index) {
		return this.getDrewNumbers(index).size();
	}

	public LottoryType getType() {
		return type;
	}

	public void setPools(Pool[] pools) {
		this.pools = Arrays.asList(pools);
	}

	public String toString() {
		return this.getPrimalInfo();
	}

}
