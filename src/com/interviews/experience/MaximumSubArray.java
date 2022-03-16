package com.interviews.experience;

/**
 * 
 * Print maximum contiguous subarray from a given Array
 * Input: array[] = {-2, -3, 4, -1, -2, 1, 5, -3}
 * Output: 7
 * [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * 
 */
public class MaximumSubArray {

	public static void main(String[] args) {
		System.out.print("Input Array is ");
		int[] inputArray = {-2,1,-3,4,-1,2,1,-5,4};
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(" "+ inputArray[i] +" ");
		}
		System.out.println();
		System.out.println("MaxSum value is "+maxSubArray(inputArray));
	}
	
	 public static int maxSubArray(int[] nums) {
		 // Initialize our variables using the first element.
	        int currentSubarray = nums[0];
	        int maxSubarray = nums[0];
	        
	        // Start with the 2nd element since we already used the first one.
	        for (int i = 1; i < nums.length; i++) {
	            int num = nums[i];
	            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
	            currentSubarray = Math.max(num, currentSubarray + num);
	            maxSubarray = Math.max(maxSubarray, currentSubarray);
	        }
	        
	        return maxSubarray;
	    }

}
