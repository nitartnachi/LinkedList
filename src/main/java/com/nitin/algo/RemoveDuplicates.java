/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,

Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

 */

package com.nitin.algo;

import com.nitin.algo.LinkedListUtils.Node;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,3,4,4,5,5,5,6};
		Node head = LinkedListUtils.createLinkedList(arr);
		LinkedListUtils.printList(head);
		
		head = removeDuplicates(head);
		LinkedListUtils.printList(head);

		head = LinkedListUtils.createLinkedList(arr);
		LinkedListUtils.printList(head);
		
		head = deleteDuplicates(head);
		LinkedListUtils.printList(head);
	}

	// this method removes the entries which occur more than once
	// 1->1->2->3 will result in 2->3
	private static Node deleteDuplicates(Node head) {
		if(head == null || head.next == null)
			return head;
		
		Node dummy = new Node(0);
		dummy.next = head;
		Node cur = dummy;
		
		while(cur.next != null && cur.next.next != null) {
			if(cur.next.data == cur.next.next.data) {
				int dup = cur.next.data;
				while(cur.next != null && cur.next.data == dup)
					cur.next = cur.next.next;
			}else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}

	// this method removes duplicates
	// 1->1->1->2->2->3->4->4->5->5->5 will result in 1->2->3->4->5
	private static Node removeDuplicates(Node head) {
		if(head == null || head.next == null)
			return head;
		
		Node pre = head;
		Node cur = head.next;
		
		while(cur != null) {
			if(pre.data == cur.data) {
				pre.next = cur.next;
			}else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}

}
