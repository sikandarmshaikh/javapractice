package com.algoexpert.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * Find Two numbers in the array whose Sum is equal to the Target value
 * Input Array : {3,5,-4,8,11,1,-1,6} Target = 10
 * Output: 11  -1
 *
 */
public class TwoNumerSumSolution1 {
	
	public static void main(String[] args) {
		
		int array[] = {3,5,-4,8,11,1,-1,6};
		int result[] = {0,0};
		result = twoNumberSum(array, 10);
		System.out.println(result[0]+"  "+result[1]);
		
		result = twoNumberSumSolution2(array, 10);
		System.out.println(array[result[0]]+"  "+array[result[1]]);
		
		result = twoNumberSumSolution2(array, 10);
		System.out.println(array[result[0]]+"  "+array[result[1]]);
	}
	
	public static int[] twoNumberSumSolution3(int[] nums, int target) {
		
		int[] output = new int[2];
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(i)) {
				output[0] = map.get(nums[i]);
				output[1]= i;
				return output;
			}
			map.put(target-nums[i], i);
		}
		return output;
	}
	
	public static int[] twoNumberSumSolution2(int[] nums, int target) {
		int[] output = {0,0};
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if ((nums[i] + nums[j]) == target) {
					output[0] = i;
					output[1] = j;
					return output;	
				}
			}
		}
		return output;
	}
	
	public static int[] twoNumberSum(int[] array, int targetSum) {
		
	    for(int i=0;i<array.length-1;i++){
	    	int firstNum = array[i];
	    	for(int j=i+1;j<array.length;j++){
	    		int secondNum = array[j];
	    		if(firstNum+secondNum==targetSum){
					return new int[] {firstNum,secondNum};		
	    		}
	    	}
	    }
	    return new int[0];
	} 
}
