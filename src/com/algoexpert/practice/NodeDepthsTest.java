package com.algoexpert.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.algoexpert.practice.NodeDepths.BinaryTree;

public class NodeDepthsTest {

	@Test
    public void TestCase1() {
		
		BinaryTree bt = new NodeDepths.BinaryTree(1);
		bt.left = new NodeDepths.BinaryTree(2);
		bt.right = new NodeDepths.BinaryTree(3);
		bt.left.left = new NodeDepths.BinaryTree(4);
		bt.left.right = new NodeDepths.BinaryTree(5);
		bt.right.left = new NodeDepths.BinaryTree(6);
		bt.right.right = new NodeDepths.BinaryTree(7);
		bt.left.left.left = new NodeDepths.BinaryTree(8);
		bt.left.left.right = new NodeDepths.BinaryTree(9);
		
		int sum = NodeDepths.nodeDepths(bt);
		System.out.println("Node Depth of the Bunary Tree is "+sum);
		assertEquals(sum, 16);
		
	}
}
