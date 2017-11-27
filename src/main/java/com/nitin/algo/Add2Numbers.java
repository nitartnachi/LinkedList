/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) 
 *      + (5 -> 6 -> 4)
 *      
 * Output: 7 -> 0 -> 8
 */
package com.nitin.algo;

import com.nitin.algo.LinkedListUtils.Node;

	public class Add2Numbers {
		
		public static void main(String[] args) {
			int[] arr1 = {3,4,2};
			int[] arr2 = {4,6,5};
			Node head1 = LinkedListUtils.createLinkedList(arr1);
			Node head2 = LinkedListUtils.createLinkedList(arr2);
			head1 = ReverseLinkedList.reverseIterative(head1);
			head2 = ReverseLinkedList.reverseIterative(head2);
			LinkedListUtils.printList(head1);
			LinkedListUtils.printList(head2);
			
			Node head = add2Numbers(head1, head2);
			LinkedListUtils.printList(head);
	}

		private static Node add2Numbers(Node head1, Node head2) {
			if(head1 == null || head2 == null)
				return null;
			
			Node head = new Node(0);
			int carry = 0;
			
			Node n1 = head1, n2 = head2, n3 = head;
			
			while(n1 != null || n2 != null) {
				if(n1 != null) {
	                carry += n1.data;
	                n1 = n1.next;
	            }
	 
	            if(n2 != null) {
	                carry += n2.data;
	                n2 = n2.next;
	            }
	            n3.next = new Node(carry % 10);
	            n3 = n3.next;
	            carry /= 10;
			}
			if(carry == 1)
				n3.next = new Node(1);
			
			return head.next;
				
		}

}
