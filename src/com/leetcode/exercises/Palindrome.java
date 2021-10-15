package com.leetcode.exercises;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;


public class Palindrome {

	/**
	 * Approach 1: Copy into Array List and then Use Two Pointer Technique
	 * Time complexity : O(n)O(n), where nn is the number of nodes in the Linked List.
	 * Space complexity : O(n)O(n), where nn is the number of nodes in the Linked List.
	 */
	public static boolean isPalindrome(ListNode head) {
		
		List<Integer> vals = new ArrayList<>();
		ListNode currentNode = head;
		//Convert LinkedList into ArrayList
		while(currentNode!=null) {
			vals.add(currentNode.data);
			currentNode = currentNode.next;
		}
		
		List<Integer> reverseLinkedList = new ArrayList<Integer>();
		// Reverse vals ArrayList
		for (int i = vals.size()-1; i >= 0 ; i--) {
			reverseLinkedList.add(vals.get(i));
		}
		
		//Check if the two array list are equal to each other
		for (int i = 0; i < vals.size()-1; i++) {
			if(!vals.get(i).equals(reverseLinkedList.get(i)))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		
		ListNode node = head;
		for (int i=0; i < 4; i++) {
			if(node!=null)
				System.out.println("Actual List::" + node.data);
			node = node.getNext();
		}
		boolean isPalindrome = Palindrome.isPalindrome(head);
		System.out.println(isPalindrome);
	}
	
	public static class ListNode {

		int data;
		ListNode next;

		public ListNode() {
		}

		public ListNode(int data) {
			this.data = data;
		}

		public ListNode(int data, ListNode next) {
			this.data = data;
			this.next = next;
		}

		public int getData() {
			return data;
		}

		public ListNode getNext() {
			return next;
		}

		public void setData(int data) {
			this.data = data;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}

	}

}
