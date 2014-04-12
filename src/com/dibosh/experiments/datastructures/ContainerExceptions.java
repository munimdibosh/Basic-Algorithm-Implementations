/**
 * @author Md. Abdul Munim Dibosh
 * 
 * This piece of code is a contribution to open source codebase.
 */
package com.dibosh.experiments.datastructures;

public class ContainerExceptions{
	public static class EmptyException extends Exception{
		public EmptyException(){
			super("Container is empty");
		}
	}
	public static class FullException extends Exception{
		public FullException(){
			super("Container is full");
		}
	}
	public static class NotFoundException extends Exception{
		public NotFoundException(){
			super("Element not found");
		}
	}
}
