package com.dibosh.experiments.datastructures;

import com.dibosh.experiments.datastructures.ContainerExceptions.FullException;

public class IntegerStack extends Stack<Integer>{

	int MIN=Integer.MIN_VALUE;//this will hold the minimum of the stack
	int MAX=Integer.MAX_VALUE;//this will hold the minimum of the stack
	public IntegerStack(int capacity) {
		super(capacity);
	}
	
	@Override
	public void push(Integer i){
		try {
			super.push(i);
		} catch (FullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(MIN == Integer.MIN_VALUE || i < MIN)MIN = i;
		if(MAX == Integer.MAX_VALUE || i > MAX)MAX = i;
	}
	/**
	 * Returns the min of the stack
	 * @return
	 */
	public int min(){
		return MIN;
	}
	
	/**
	 * Returns the max of the stack
	 * @return
	 */
	public int max(){
		return MAX;
	}
	
	

}
