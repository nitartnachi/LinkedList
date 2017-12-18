/*
 * Implement the following operations of a queue using stacks.
 * add(x) -- Push element x to the back of queue.
 * remove() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 */

package com.nitin.algo;

import java.util.Stack;

public class QueueUsingStacks {

	Stack<Integer> one;
	Stack<Integer> two;
	int size;

	public QueueUsingStacks(){
		one = new Stack<>();
		two = new Stack<>();
		size = 0;
	}

	public static void main(String[] args) {
		QueueUsingStacks queue = new QueueUsingStacks();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		//queue.add(4);
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println("Is Emnpty: " + queue.isEmpty());
		System.out.println(queue.peek());
		System.out.println(queue.remove());
		System.out.println("Is Emnpty: " + queue.isEmpty());
	}

	private boolean isEmpty() {
		return size == 0;
	}

	private int remove() {
		size--;
		return one.pop();
	}

	private int peek() {
		return one.peek();

	}

	private void add(int i) {
		if(one.isEmpty())
			one.push(i);
		else {
			while(!one.isEmpty())
				two.push(one.pop());
			one.push(i);
			while(!two.isEmpty())
				one.push(two.pop());
		}
		size++;
	}

}
