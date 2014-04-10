/**
 * @author Md. Abdul Munim Dibosh
 * 
 * This piece of code is a contribution to open source codebase.
 */
package com.dibosh.experiments.datastructures;

public class LinkedList<T extends Object> extends DataContainer {

	public final static int SINGLY = 1;
	public final static int DOUBLY = 2;
	int TYPE = SINGLY;//default
	class Node{
		public Node prev;
		public Node next;
		public T element;
		public Node(Node prev,Node next,T e){
			this.prev = prev;
			this.next = next;
			element = e;
		}
	}
	Node head,tail;
	public LinkedList(int type){
		TYPE = type;
		switch(type){
			case SINGLY:
//				head = new Node(null,, e)
				break;
			case DOUBLY:
				break;
		}
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
