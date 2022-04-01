package com.fp.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * Comparable Vs Comparator
 *
 */
public class ComparableVsComparator {
	
	public static void main(String[] args) {
		
		List<AthleteClassComparable> l1 = new ArrayList<>();
		l1.add(new AthleteClassComparable("Smith", 100));
		l1.add(new AthleteClassComparable("James", 300));
		l1.add(new AthleteClassComparable("Sam", 400));
		l1.add(new AthleteClassComparable("Jane", 600));
		l1.add(new AthleteClassComparable("Ron", 500));
		
		//Sort using Comparable
		//Collections.sort(l1);

		//Sort using Comparator
		Collections.sort(l1, new ComparatorSortInDescendingOrder());
		System.out.println(l1);
	}

}
