package com.algoexpert.medium.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * Input: nums = []
 * Output: []
 * Example 3:
 * Input: nums = [0]
 * Output: []
 * Constraints:
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * 
 * Time Complexity - O(n^2) time Space Complexity - O(n) space
 * 
 */
public class ThreeNumberSum {

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		int target = 0;
		List<Integer[]> triplets = threeNumberSum(nums,target);
		for (Iterator iterator = triplets.iterator(); iterator.hasNext();) {
			Integer[] integers = (Integer[]) iterator.next();
			System.out.print("[");
			for (Integer integer : integers) {
				System.out.print(integer+",");
			}
			System.out.print("]");
		}
	}

	private static List<Integer[]> threeNumberSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<Integer[]> triplets = new ArrayList<Integer[]>();
		int left = 0, right = 0, currentSum = 0;
		for (int i = 0; i < nums.length-2; i++) {
			left = i+1;
			right = nums.length-1;
			while(left<right) {
				currentSum = nums[i]+nums[left]+nums[right];
				if(currentSum == target) {
					Integer[] newTriplet = {nums[i], nums[left], nums[right]};
					triplets.add(newTriplet);
					left++;
					right--;
				} else if(currentSum<target)
					left++;
				  else if(currentSum>target)
					right--;
			}
		}
		return triplets;
	}
}
