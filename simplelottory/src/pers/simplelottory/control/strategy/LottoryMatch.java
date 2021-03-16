package pers.simplelottory.control.strategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pers.simplelottory.model.Pool;

public abstract class LottoryMatch {
	public List<Pool> default_match(List<Pool> origin, List<Pool> master) {
		Iterator<Integer> it1;
		Iterator<Integer> it2;
		List<Pool> results = new ArrayList<>();

		for (int i = 0; i < origin.size(); i++) {
			results.add(new Pool(0));
			it1 = origin.get(i).getDrewNumbers().iterator();
			it2 = master.get(i).getDrewNumbers().iterator();
			if (!(it1.hasNext() && it2.hasNext())) {
				break;
			}
			Integer n1 = it1.next(), n2 = it2.next();
			while (true) {
				if (n1 == n2) {
					results.get(i).getDrewNumbers().add(n1);
					if (it1.hasNext() && it2.hasNext()) {
						it1.next();
						it2.next();
					} else {
						break;
					}
				} else if (n1 < n2) {
					if (it1.hasNext()) {
						it1.next();
					} else {
						break;
					}
				} else {
					if (it2.hasNext()) {
						it2.next();
					} else {
						break;
					}
				}
			}
		}
		return results;
	}

	public abstract List<Pool> match(List<Pool> origin, List<Pool> master);// return matched List<Pool>
}
