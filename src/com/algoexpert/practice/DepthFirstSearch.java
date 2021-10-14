package com.algoexpert.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Depth First Search
 * Input Array: "A","B","E","F","I","J","C","D","G","K","H"
 * expected Array: "A","B","E","F","I","J","C","D","G","K","H"
 * Output: true
 *
 */
public class DepthFirstSearch {

	public static class Node {
	    String name;
	    public List<Node> children = new ArrayList<Node>();

	    public Node(String name) {
	      this.name = name;
	    }

	    public List<String> depthFirstSearch(List<String> array) {
	      array.add(this.name);
			for (int i = 0; i < children.size(); i++) {
				children.get(i).depthFirstSearch(array);
			}
				return array;
	    }

	    public Node addChild(String name) {
	      Node child = new Node(name);
	      children.add(child);
	      return this;
	    }
	  }
	
	public static void main(String[] args) {
		DepthFirstSearch.Node graph = new DepthFirstSearch.Node("A");
		graph.addChild("B").addChild("C").addChild("D");
		graph.children.get(0).addChild("E").addChild("F");
		graph.children.get(2).addChild("G").addChild("H");
		graph.children.get(0).children.get(1).addChild("I").addChild("J");
		graph.children.get(2).children.get(0).addChild("K");
		List<String> expected = Arrays.asList("A","B","E","F","I","J","C","D","G","K","H");
		List<String> inputArray = new ArrayList<String>();
		System.out.println(compare(graph.depthFirstSearch(inputArray),expected));
	}
	
	// This is written to just compare the 2 ArrayLists
	public static boolean compare(List<String> arr1, List<String> arr2) {
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
