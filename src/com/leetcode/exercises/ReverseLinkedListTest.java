package com.leetcode.exercises;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.leetcode.exercises.ReverseLinkedList.ListNode;

public class ReverseLinkedListTest {

	ListNode constructLinkedList() {

		ListNode head = null;
		ListNode tail = null;
		for (int i = 0; i <= 5; i++) {
			ListNode node = new ListNode(i);
			if (head == null) {
				head = node;
			} else {
				tail.setNext(node);
			}
			tail = node;
		}
		return head;
	}

	@Test
	public void iterativelyReverseListTestCase() {
		ListNode head = constructLinkedList();
		ListNode node = head;
		for (int i = 0; i <= 5; i++) {
			assertNotNull(node);
			assertEquals(i, node.getData());
			node = node.getNext();
		}
		node = ReverseLinkedList.reverseList(head);
		for (int i = 5; i >= 1; i--) {
			assertNotNull(node);
			assertEquals(i, node.getData());
			System.out.println("Iterative: " + node.getData());
			node = node.getNext();
		}
	}
	
	@Test
	public void RecursivelyReverseListTestCase() {
		ListNode head = constructLinkedList();
		ListNode node = head;
		for (int i = 0; i <= 5; i++) {
			assertNotNull(node);
			assertEquals(i, node.getData());
			node = node.getNext();
		}
		node = ReverseLinkedList.reverseListRecursively(head);
		for (int i = 5; i >= 1; i--) {
			assertNotNull(node);
			assertEquals(i, node.getData());
			System.out.println("Recursive: " + node.getData());
			node = node.getNext();
		}
	}

}
