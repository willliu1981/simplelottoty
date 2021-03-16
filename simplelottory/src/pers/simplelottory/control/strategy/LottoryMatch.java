package pers.simplelottory.control.strategy;

import java.util.List;

import pers.simplelottory.model.Pool;

public abstract class LottoryMatch {
	public int default_match(List<Pool> origin,List<Pool> matchTo) {
		System.out.println("xxx");
		return 0;
	}
	public abstract int match(List<Pool> origin,List<Pool> matchTo);//return count of matched result numbers 
}
