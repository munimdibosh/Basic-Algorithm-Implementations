/**
 * @author Md. Abdul Munim Dibosh
 * 
 * This piece of code is a contribution to open source codebase.
 */
package com.dibosh.experiments.datastructures;

import java.util.ArrayList;

import com.dibosh.experiments.datastructures.ContainerExceptions.EmptyException;
import com.dibosh.experiments.datastructures.ContainerExceptions.FullException;

public class Stack<T extends Object> extends DataContainer{
	ArrayList<T> objects;
	int STACK_CAPACITY;
	public Stack(int capacity){
		STACK_CAPACITY = capacity;
		objects = new ArrayList<T>();
	}
	private boolean isFull(){
		return size()==STACK_CAPACITY;
	}
	/**
	 * Pushes an object in the stack
	 * @param o
	 * @throws FullException 
	 */
	public void push(T o) throws FullException{
		if(isFull())throw new ContainerExceptions.FullException();
		objects.add(o);
	}
	/**
	 * Returns the top object and deletes it from the stack
	 * @return
	 * @throws EmptyException 
	 */
	public T pop() throws EmptyException{
		if(isEmpty()) throw new EmptyException();
		T object = (T) objects.get(size()-1);
		objects.remove(objects.size()-1);
		return object;
	}
	/**
	 * Returns the top object without deleting it from the stack
	 * @return
	 */
	public T top() throws EmptyException{
		if(isEmpty()) throw new EmptyException();
		return (T) objects.get(objects.size()-1);
	}
	@Override
	public int size() {
		return objects.size();
	}
	@Override
	public boolean isEmpty() {
		return objects.size() == 0;
	}
	
	public void print(){
		System.out.println("**Printing the stack**");
		for(T o : objects){
			System.out.println(o);
		}
		System.out.println("**Done printing the stack**");
	}
}
