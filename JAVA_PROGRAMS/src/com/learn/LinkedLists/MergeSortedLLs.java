package com.learn.LinkedLists;

public class MergeSortedLLs {
	
	static class Node{
		int data;
		Node next;
		
		Node(int x){
			this.data = x;
			this.next = null;
		}
	}
	
	public static void main(String[] args) {
		
		Node a = new Node(2);
		a.next = new Node(4);
		a.next.next = new Node(8);
		a.next.next.next = new Node(9);
		
		Node b = new Node(3);
		b.next = new Node(5);
		b.next.next = new Node(10);
		
		Node res = mergeLists(a, b);
		
		while(res != null) {
			System.out.println(res.data + " ");
			res = res.next;
		}
	}

	private static Node mergeLists(Node a, Node b) {
		
		if(a == null) return b;
		if(b == null) return a;
		
		Node head = null;
		Node tail = null;
		
		if(a.data <= b.data)
		{
			head = tail = a;
			a = a.next;
		}else {
			head = tail = b;
			b = b.next;
		}
		
		
		while(a!= null && b!= null) {
			if(a.data <= b.data) {
				tail.next = a;
				tail = a;
				a= a.next;
			}else {
				tail.next = b;
				tail = b;
				b = b.next;
			}
		}
		
		tail.next = (a != null) ? a : b;
		
		return head;
	}

}
