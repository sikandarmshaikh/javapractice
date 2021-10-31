package codility.interview.programs.german.company;

/**
 * 
 * Write a function to a solution that, given an array A of N integers between -100 and 100 returns the sign (-1,0,1) of the product
 * of all the numbers in the array multiplied together. Assume that N is between 1 and 1000.
 * 
 * For example 
 * 
 * Codility interview Question
 * https://leetcode.com/problems/sign-of-the-product-of-an-array/
 * There is a function signFunc(x) that returns:
 * 1 if x is positive.
 * -1 if x is negative.
 * 0 if x is equal to 0.
 * You are given an integer array nums. Let product be the product of all values in the array nums.
 * Return signFunc(product).
 *
 */
public class  SignOfTheProductOFArray{
	
	public int arraySign(int[] nums) {
		
		int negativeCount = 0;

		for (int num : nums) {
			if (num == 0)
				return 0;
			if (num < 0)
				negativeCount++;
		}
		return negativeCount % 2 == 0 ? 1 : -1;
	}
	
	public static void main(String[] args) {
		
	}
}
