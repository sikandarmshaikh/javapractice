package com.algoexpert.easy.practice.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import com.algoexpert.easy.practice.NonConstructibleChange;


public class NonConstructibleChangeTest {

	@Test
	public void test() {
		int[] inputArray = {5,7,1,1,2,3,22};
		int expected = 20;
		int result = NonConstructibleChange.nonConstructibleChange(inputArray);
		assertEquals(result, expected);
		assertTrue(result==expected);
	}

}
