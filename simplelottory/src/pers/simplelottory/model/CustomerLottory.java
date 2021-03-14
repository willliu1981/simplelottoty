package pers.simplelottory.model;

import java.util.ArrayList;
import java.util.List;

import pers.simplelottory.control.excpetion.EndOfLottoryListException;

public class CustomerLottory  {
	protected List<Lottory> lottories;
	protected Integer lottory_period;
	protected int pointer=0;
	
	public CustomerLottory(int period) {
		lottories=new ArrayList<>();
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
		if(this.pointer>=this.lottories.size()) {
			throw new EndOfLottoryListException(this.pointer);
		}
		return this.lottories.get(pointer);
	}
	
	
	
}
