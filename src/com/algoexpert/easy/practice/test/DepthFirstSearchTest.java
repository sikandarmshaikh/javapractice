package com.algoexpert.easy.practice.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.algoexpert.easy.practice.DepthFirstSearch;

public class DepthFirstSearchTest {

	@Test
	public void TestCase1() {
		DepthFirstSearch.Node graph = new DepthFirstSearch.Node("A");
		graph.addChild("B").addChild("C").addChild("D");
		graph.children.get(0).addChild("E").addChild("F");
		graph.children.get(2).addChild("G").addChild("H");
		graph.children.get(0).children.get(1).addChild("I").addChild("J");
		graph.children.get(2).children.get(0).addChild("K");
		List<String> expected = Arrays.asList("A","B","E","F","I","J","C","D","G","K","H");
		List<String> inputArray = new ArrayList<String>();
		assertTrue(compare(graph.depthFirstSearch(inputArray),expected));
	}

	public boolean compare(List<String> arr1, List<String> arr2) {
		if(arr1.size() != arr2.size()) {
			return false;
		}
		for (int i = 0; i < arr1.size(); i++) {
			if(!arr1.get(i).equals(arr2.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	

}
