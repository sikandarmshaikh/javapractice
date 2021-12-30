package com.algoexpert.easy.practice.test;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.algoexpert.easy.practice.TwoNumerSumSolution1;


public class TwoNumerSumSolution1Test {

	@Test
	public void TestCase1() {
		int[] output = TwoNumerSumSolution1.twoNumberSum(new int[] {3,5,-4,8,11,1,-1,6}, 10);
		assertTrue(output.length == 2);
		assertTrue(contains(output, -1));
		assertTrue(contains(output, 11));
	}

	
	public boolean contains(int[] output, int val) {
		for (int el : output) {
			if (el == val)
				return true;
		}
		return false;
	}

}
