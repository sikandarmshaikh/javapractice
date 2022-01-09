package com.interviews.experience;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JPMC 4th Round
 * Find the Top 3 Brokers who are appearing most of the times in the ArrayList
 *
 */
public class FindTop3MostOccuringNumbersInList {
	
	
	
	public static void main(String[] args) {
		List<Integer> result = topBrokers(new int[] {1,3,5,12,11,12,11,12,5},3);
		
		System.out.println("Top 3 Broker IDS are "+result);
		
	}

	private static List<Integer> topBrokers(int[] input, int k) {
		
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		int counter = 0;
		for (int i = 0; i < input.length; i++) {
			int j = i+1;
			if(i==j) {
				map.put(input[i], counter++);
				map.getOrDefault(result, null);
			}
		}
		
		result.add(map.get(0));
		result.add(map.get(1));
		result.add(map.get(2));
		
		return result;
	}
}
