package com.algoexpert.easy.practice.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.algoexpert.easy.practice.SortSquaredArray;

class SortSquaredArrayTest {

	@Test
	public void TestCase1() {
		List<Integer> actual = Arrays.asList(1,2,3,4,5,6,7,8,9);
		List<Integer> expected = Arrays.asList(1, 4, 9, 16, 25, 36, 49, 64, 81);
		Collections.sort(actual);
		List<Integer> sortedArray = SortSquaredArray.sortedSquaredArraySol1(actual);
		Collections.sort(sortedArray);
		boolean isSquared = expected.equals(sortedArray);
		assertEquals(true, isSquared);
		assertTrue(isSquared);
	}
}
