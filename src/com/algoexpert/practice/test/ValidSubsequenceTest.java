package com.algoexpert.practice.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.algoexpert.practice.ValidSubsequence;

public class ValidSubsequenceTest {

	@Test
	public void TestCase1() {
		List<Integer> array = Arrays.asList(5,1,22,25,6,-1,8,10);
		List<Integer> sequence = Arrays.asList(1,6,-1,10);
		assertEquals(true, ValidSubsequence.isValidSubsequenceSol1(array, sequence));
	}
}
