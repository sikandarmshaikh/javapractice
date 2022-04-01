package com.fp.practice;

import java.util.Comparator;

public class ComparatorSortInDescendingOrder implements Comparator<AthleteClassComparable>{

	@Override
	public int compare(AthleteClassComparable o1, AthleteClassComparable o2) {
		if(o1.score > o2.score) {
			return -1;
		}
		if(o1.score < o2.score) {
			return 1;
		}
		return 0;
	}
}
