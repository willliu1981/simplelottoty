package pers.simplelottory.control;

import java.util.List;

import pers.simplelottory.model.Pool;

public abstract class LottoryMatch {
	public int default_match(List<Pool> origin,List<Pool> matchTo) {
		
		return 0;
	}
	public abstract int match(List<Pool> origin,List<Pool> matchTo);//return count of matched result numbers 
}
