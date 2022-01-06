package com.interviews.experience;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JPMC 4th Round
 * 
 *
 */
public class Assessment2 {
	
	
	
	public static void main(String[] args) {
		List<Integer> result = topBrokers(new int[] {1,3,5,12,11,12,11,12,5},3);
		
		System.out.println("Top 3 Broker IDS are "+result);
		
	}

	private static List<Integer> topBrokers(int[] input, int k) {
		
		Map<Integer, Integer> map = new HashMap<>();
		int counter = 0;
		for (int i = 0; i < input.length; i++) {
			int j = i+1;
			if(i==j) {
				map.put(input[i], counter++);
			}
			
			
			
		}
		
		
		for (int i = 0; i < input.length; i++) {
			for (int j = 1; j < input.length; j++) {
				if(map.get(i)==map.get(j)) {
					map.put(i, counter++);
				}
			}
		}
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			/*keyType key = entry.getKey();
			valType val = entry.getValue();*/
			
		}
		
		return null;
	}
}
