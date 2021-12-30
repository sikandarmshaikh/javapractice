package com.algoexpert.easy.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input Graph
 * 								A
 * 						B		C		 D
 * 					  E   F   G	  H	   I   J	
 * 					 	 I J   K
 * 
 * 
 * 
 * 
 * 
 * 
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
		
		 // Given String
	    String s = "50552";
	 
	    // Function call
	    int i = largestSubsequence(s);
	    System.out.println("largestSubsequence:: "+i);
		
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
	
	public int Solution(String s) {
		
		return 1;
	}
	
	static int largestSubsequence(String s1)
	{
		char[] s = s1.toCharArray();
	    // Variable initialization
	    int maxi = 0;
	    char prev1;
	 
	    // Nested loops for iteration
	    for (int i = 0; i < 10; i++)
	    {
	        for (int j = 0; j < 10; j++)
	        {
	 
	            // Check if i is not equal to j
	            if (i != j)
	            {
	 
	                // Initialize length as 0
	                int len = 0;
	                prev1 = (char) (j + '0');
	 
	                // Iterate from 0 till the
	                // size of the String
	                for (int k = 0; k < s.length; k++)
	                {
	                    if (s[k] == i + '0' &&
	                        prev1 == j + '0')
	                    {
	                        prev1 = s[k];
	 
	                        // Increment length
	                        len++;
	                    }
	                    else if (s[k] == j + '0' &&
	                             prev1 == i + '0')
	                    {
	                        prev1 = s[k];
	 
	                        // Increment length
	                        len++;
	                    }
	                }
	 
	                // Update maxi
	                maxi = Math.max(len, maxi);
	            }
	        }
	    }
	 
	    // Check if maxi is not equal to
	    // 1 the print it otherwise print 0
	    if (maxi != 1)
	        //System.out.print(maxi + "\n");
	    	return maxi;
	    else
	    	return 0;
	        //System.out.print(0 + "\n");
	}
	
}
