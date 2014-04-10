/**
 * @author Md. Abdul Munim Dibosh
 * 
 * This piece of code is a contribution to open source codebase.
 */
package com.dibosh.experiments.datastructures;

import java.util.ArrayList;

public class Queue<T extends Object> extends DataContainer {
	int QUEUE_CAPACITY;
	ArrayList<T> objects = new ArrayList<T>();
	public Queue(int capacity){
		QUEUE_CAPACITY = capacity;
	}
	private boolean isFull(){
		return size()==QUEUE_CAPACITY;
	}
	/**
	 * Inserts an object o at the rear of the queue
	 * @param o
	 */
	public void enequeue(T o) throws ContainerExceptions.FullException{
		if(isFull()) throw new ContainerExceptions.FullException();
		objects.add(o);
	}
	/**
	 * Returns the front object and deletes it from the queue
	 * @return
	 */
	public T dequeue() throws ContainerExceptions.EmptyException{
		if(isEmpty())throw new ContainerExceptions.EmptyException();
		T object = objects.get(0);
		objects.remove(0);
		return object;
	}
	/**
	 * Returns the first object without deleting it from the queue
	 * @return
	 */
	public T first() throws ContainerExceptions.EmptyException{
		if(isEmpty()) throw new ContainerExceptions.EmptyException();
		return objects.get(0);
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return objects.size();
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size()==0;
	}
	
	public void print(){
		System.out.println("**Printing the stack**");
		for(T o : objects){
			System.out.println(o);
		}
		System.out.println("**Done printing the stack**");
	}

}
