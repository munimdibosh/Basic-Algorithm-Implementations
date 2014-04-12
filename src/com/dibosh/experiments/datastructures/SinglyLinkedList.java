/**
 * @author Md. Abdul Munim Dibosh
 * 
 * This piece of code is a contribution to open source codebase.
 */
package com.dibosh.experiments.datastructures;

import java.util.HashSet;

import com.dibosh.experiments.datastructures.ContainerExceptions.NotFoundException;

public class SinglyLinkedList<T extends Object> extends DataContainer {

	int nodeCount = 0;
	class Node{
		public Node next;
		public T element;
		public Node(T e){
			element = e;
		}
	}
	Node head,tail;
	public SinglyLinkedList(){
		head = new Node(null);
		head.next = null;
		tail = head;//at first both are same
	}
	
	public void addAll(T[] array){
		for(T o : array){
			add(o);
		}
	}
	public void add(T o){
		Node lastNode = tail;
		Node node = new Node(o);
		lastNode.next = node;
		tail = node;//the new node is now the tail
		nodeCount++;
	}
	
	public void insertAfter(T current,T newone) throws NotFoundException{
		Node currentNode = head;
		while(currentNode != null){
			if(currentNode.next != null && currentNode.next.element.equals(current)){
				//the next node has the element
				Node nextNode = currentNode.next;
				Node newNode = new Node(newone);
				Node nextNextNode = nextNode.next;
				newNode.next = nextNextNode;
				nextNode.next = newNode;
				return;
			}
			currentNode = currentNode.next;
		}
		
		throw new ContainerExceptions.NotFoundException();
	}
	public void clear(){
		if(head.next != null)head.next = null;
	}
	public void remove(T o) throws NotFoundException{
		Node currentNode = head;
		while(currentNode != null){
			if(currentNode.next != null && currentNode.next.element.equals(o)){
				//the next node has the element
				Node nextNode = currentNode.next;
				Node theOneAfterNextNode = nextNode.next;
				currentNode.next = theOneAfterNextNode;
				nextNode.next = null;//release the pointer to the one thats already pointed by current
				nodeCount--;
				return;
			}
			//node hopping
			currentNode = currentNode.next;
		}
		
		throw new ContainerExceptions.NotFoundException();
	}
	
	public void replace(T prev,T now) throws NotFoundException{
		Node currentNode = head;
		while(currentNode != null){
			if(currentNode.next != null && currentNode.next.element.equals(prev)){
				//the next node has the element
				Node nextNode = currentNode.next;
				nextNode.element = now;
				return;
			}
			currentNode = currentNode.next;
		}
		
		throw new ContainerExceptions.NotFoundException();
	}
	
	public void removeDuplicates(){
		HashSet<T> set = new HashSet<T>();
		Node currNode = head;
		while(currNode != null){
			if(currNode.next != null && set.contains(currNode.next.element)){
				//previously found object is going to be added again
				//restrict it by removing it
				Node nextNode = currNode.next;
				currNode.next = nextNode.next;
				nextNode = null;
			}
			//null check is required as head has null element
			if(currNode.element!=null)set.add(currNode.element);
			currNode = currNode.next;
		}
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return nodeCount;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head.next == null;
	}

	
	public void print(){
		Node node = head;
		while(node.next != null){
			System.out.print(node.next.element+"\t");
			node = node.next;
		}
		System.out.println();
	}
}
