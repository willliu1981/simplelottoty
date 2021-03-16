package pers.simplelottory.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pers.simplelottory.control.excpetion.DrawFinishException;
import pers.simplelottory.control.strategy.LottoryDraw;
import pers.simplelottory.control.strategy.LottoryMatch;

public class Lottory {
	private static Integer auto_increment = 0;

	private List<Pool> pools;
	private LottoryDraw draw;
	private LottoryMatch match;
	private LottoryType type;
	private Integer id;

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

		public static LottoryType findByValue(String value) {
			return Arrays.asList(LottoryType.values()).stream().filter(x -> x.value.equalsIgnoreCase(value)).findFirst()
					.get();
		}

		public static LottoryType findByDefinename(String name) {
			return Arrays.asList(LottoryType.values()).stream().filter(x -> x.defineName.equalsIgnoreCase(name))
					.findFirst().get();
		}

		public static boolean containsValue(String value) {
			return Arrays.asList(LottoryType.values()).stream().filter(x -> x.value.equalsIgnoreCase(value)).findFirst()
					.isPresent();
		}
	}

	public Lottory(LottoryType type, Pool... pools) {
		this.setId();
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
			public List<Pool> match(List<Pool> origin, List<Pool> master) {
				return this.default_match(origin, master);
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

	public List<Integer> get(int index) {
		return this.getDrewNumbers(index);
	}

	public void set(List<Integer> data, int index) {
		this.getPool(index).set(data);
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
		StringBuilder sb = new StringBuilder(this.getId()+": ");
		if (sort) {
			this.getDefaultPoolDrewNumbers().stream().sorted().forEach(x -> sb.append(" " + x));
		} else {
			this.getDefaultPoolDrewNumbers().forEach(x -> sb.append(" " + x));
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

	public List<Pool> getPools() {
		return pools;
	}

	public List<Pool> match(Lottory master) {
		return this.match.match(this.pools, master.getPools());
	}

	public Integer getId() {
		return id;
	}

	private void setId() {
		this.id = auto_increment++;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}

	public String toString() {
		return this.getPrimalInfo();
	}

}
