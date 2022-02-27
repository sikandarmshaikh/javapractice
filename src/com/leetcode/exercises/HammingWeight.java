package com.leetcode.exercises;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has 
 * (also known as the Hamming weight).
 * Note:
 * Note that in some languages, such as Java, there is no unsigned integer type. 
 * In this case, the input will be given as a signed integer type. It should not affect your implementation, 
 * as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation.
 * Therefore, in Example 3, the input represents the signed integer. -3.
 *
 */
public class HammingWeight {

	public static void main(String[] args) {
		int n = 00000000000000000000000000001011;
		System.out.println("Hamming Weight is ");
		System.out.println(findHammingWeight(n));
	}
	
	public static int findHammingWeight(int n) {
		
		int bits = 0;
		int mask = 1;
		for (int i = 0; i<32; i++) {
			if((n & mask)!=0) {
				bits++;
			}
			mask <<=1;
		}
		return bits;
	}

}
