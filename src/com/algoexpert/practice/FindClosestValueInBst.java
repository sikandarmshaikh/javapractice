package com.algoexpert.practice;

/*
 * Find Closest Value in BST
 * 
 * Output: expected::13  actual::13
 */
public class FindClosestValueInBst {

	public static void main(String[] args) {
		BST root = new FindClosestValueInBst.BST(10);
		root.left = new FindClosestValueInBst.BST(5);
		root.left.left = new FindClosestValueInBst.BST(2);
		root.left.left.left  = new FindClosestValueInBst.BST(1);
		root.left.right = new FindClosestValueInBst.BST(5);
		root.right = new FindClosestValueInBst.BST(15);
		root.right.left = new FindClosestValueInBst.BST(13);
		root.right.left.right = new FindClosestValueInBst.BST(14);
		root.right.right = new FindClosestValueInBst.BST(22);
		
		int expected = 13;
		int actual = FindClosestValueInBst.findClosestValueInBst(root, 12);
		System.out.println("expected::"+expected+"  actual::"+actual);
		//assertEquals(expected, actual);
		
		//int return = FindClosestValueInBst.findClosestValueInBst(null, 0);
	}
	
	public static int findClosestValueInBst(BST tree, int target) {
	    //return findClosestValueInBst(tree, target, tree.value);
	    return findClosestValueInBstOptimalSolution(tree, target, tree.value);
	  }

	/**
	 * This is first Solution which is not Optimal
	 * @param tree
	 * @param target
	 * @param closest
	 * @return
	 */
	public static int findClosestValueInBst(BST tree, int target, int closest) {
		
		if(Math.abs(target-closest) < Math.abs(target - tree.value)) {
			closest = tree.value;
		}
		if(target < tree.value && tree.left!= null) {
			return findClosestValueInBst(tree.left, target, closest);
		} else if(target > tree.value && tree.right!= null) {
			return findClosestValueInBst(tree.right, target, closest);
		} else {
			return closest;
		}
	}
	
	/**
	 * This is 2nd Solution which is Optimal Solution
	 * @param tree
	 * @param target
	 * @param closest
	 * @return
	 */
	public static int findClosestValueInBstOptimalSolution(BST tree, int target, int closest) {
		BST currentNode = tree;
		while(currentNode!=null) {
			if(Math.abs(target-closest)  > Math.abs(target-currentNode.value)) {
				closest = currentNode.value;
			}
			if(target < currentNode.value) {
				currentNode = currentNode.left;
			} else if(target > currentNode.value) {
				currentNode = currentNode.right;
			} else {
				break;
			}
		}
		return closest;
	}

	public static class BST {
	    public int value;
	    public BST left;
	    public BST right;

	    public BST(int value) {
	      this.value = value;
	    }
	  }

}
