package com.interviews.experience;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * JPMC 4th Round
 * Find the Top 3 Brokers who are appearing most of the times in the ArrayList
 * Find k numbers with most occurrences in the given array
 */
public class FindTop3MostOccuringNumbersInList {
	
	public static void main(String[] args) {
		System.out.println("Please enter the how many Top brokers you need:");
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		scan.close();
		System.out.println("Top "+k+" brokers are:");
		topKBrokers(new int[] {1,3,5,12,11,12,11,12,5},k);
	}

	private static void topKBrokers(int[] input, int k) {
		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			map.put(input[i], 
	                   map.getOrDefault(input[i], 0) + 1);
		}
		
		List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer> >(map.entrySet());
		//Sort the List
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				if(o1.getValue()==o2.getValue()) {
					return o2.getKey() - o1.getKey();
				}else {
					return o2.getValue()-o1.getValue();
				}
			}
			
		});
		for (int i = 0; i < k; i++) {
			System.out.println(list.get(i).getKey());
		}
	}
}
