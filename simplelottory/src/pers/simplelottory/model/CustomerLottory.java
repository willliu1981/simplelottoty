package pers.simplelottory.model;

import java.util.List;

public class CustomerLottory  {
	protected List<Lottory> lottories;
	protected Integer lottory_period;
	protected int pointer=0;
	
	public CustomerLottory(int period) {
		
	}
	
	public int getPointer() {
		return this.pointer;
	}
	
	public void add(Lottory lottory) {
		this.lottories.add(lottory);
	}
	
	public boolean next() {
		this.pointer++;
		return this.pointer<this.lottories.size();
	}
	
	public Lottory get() {
		return this.lottories.get(pointer);
	}
	
	
	
}
