package pers.simplelottory.control.strategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import pers.simplelottory.model.Pool;

public abstract class LottoryMatch {
	public List<Pool> default_match(List<Pool> origin, List<Pool> master) {
		Iterator<Integer> it1;
		Iterator<Integer> it2;
		List<Pool> results = new ArrayList<>();

		for (int i = 0; i < origin.size(); i++) {
			results.add(new Pool(0));
			it1 = origin.get(i).get().stream().sorted().iterator();
			it2 = master.get(i).get().stream().sorted().iterator();
			if (!(it1.hasNext() && it2.hasNext())) {
				break;
			}
			Integer n1 = it1.next(), n2 = it2.next();
			while (true) {
				if (n1 == n2) {
					results.get(i).get().add(n1);
					if (it1.hasNext() && it2.hasNext()) {
						n1 = it1.next();
						n2 = it2.next();
					} else {
						break;
					}
				} else if (n1 < n2) {
					if (it1.hasNext()) {
						n1 = it1.next();
					} else {
						break;
					}
				} else {
					if (it2.hasNext()) {
						n2 = it2.next();
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
