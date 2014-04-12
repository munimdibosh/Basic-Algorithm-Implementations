package com.dibosh.experiments.interestingprobs;

import java.util.ArrayList;
import java.util.Collections;

import javax.sound.sampled.ReverbType;

import com.dibosh.experiments.datastructures.ContainerExceptions.EmptyException;
import com.dibosh.experiments.datastructures.ContainerExceptions.FullException;
import com.dibosh.experiments.datastructures.Stack;

public class SmallInterestingProblem {

	public static void solveTowerOfHanoy(Stack<Integer> A,Stack<Integer> C,Stack<Integer> B) throws Exception{
		int steps = 0;
		if(A.size() == 1){
			System.out.println("Moving Disk:"+A.top()+" From "+A.getLabel()+" to "+C.getLabel());
			C.push(A.pop());
			steps++;
		}else{
			Stack<Integer> temp = new Stack<Integer>(1);
			temp.setLabel("A");
			temp.push(A.pop());
			//now A has n-1 disks
			solveTowerOfHanoy(A, B, C);
			//move the nth disk from A to C
			solveTowerOfHanoy(temp, C, B);
			//move n-1 disks from B to C using A as spare
			solveTowerOfHanoy(B, C, A);
		}
	}
	/**
	 * This is interesting. Suppose a number is 1476,the summation of all the
	 * digits is 18 and now if we sum up the digits we get 9 which is smaller
	 * than 10. This program does exactly this,given a number 'n' it will keep
	 * showing the sum of it's digits until it gets smaller than 10!
	 * 
	 * @param n
	 */
	public static void calculateSumForNumber(int n) {
		int sum = 0;
		int divident = n;
		int divider = 10;
		int mod;
		do {
			while (divident != 0) {
				mod = divident % divider;
				divident = divident / divider;
				sum += mod;
			}
			divident = sum;
			System.out.println("Number:" + sum);
			sum = 0;
		} while (divident >= 10);
	}

	public static void printReverse(char[] s) {
		String reverseString = "";
		for (int i = s.length - 1; i >= 0; i--) {
			reverseString += s[i];
		}
		System.out.println(reverseString);

	}
	/**
	 * Replace any space in a string using a pattern.
	 * Use this for the problem of replacing space with %20 in crackthecode.pdf
	 * @param main
	 * @param pattern
	 */
	public static void replaceSpacesWith(String main,String pattern){
		int ptrnLen = pattern.length();
		int spaceCount = 0;
		char[] source = main.toCharArray();
		char[] ptrn = pattern.toCharArray();
		for(char c : source){
			if(c == ' ')spaceCount++;
		}
		int newLen = (source.length - spaceCount) + (spaceCount*ptrnLen);
		char[] result = new char[newLen];
		int resultIndex = 0;
		for(int i=0;i<source.length;i++){
			char c = source[i];
			if(c != ' '){
				result[resultIndex]=c;
				resultIndex++;
			}else{
				for(int j=0;j<ptrn.length;j++){
					result[resultIndex]=ptrn[j];
					resultIndex++;
				}
			}
		}
		System.out.println(new String(result));
	}
	/**
	 * Checks if the string has all the unique characters in it
	 * @param s
	 * @return
	 */
	public static boolean isAllUniqueChars(String s) {
		// make sure the spaces are not taken in account
		char[] chars = s.replaceAll(" ", "").toLowerCase().toCharArray();
		boolean found[] = new boolean[256];// ASCII charecter set
		for (char c : chars) {
			int val = c;
			System.out.println(c + ":" + val);
			// found before
			if (found[val])
				return false;
			found[val] = true;
		}
		return true;
	}
	/**
	 * Checks if a and b are anagrams 
	 * @param a
	 * @param b
	 */
	public static void anagram(String a,String b){
		if(a.length() != b.length())return;
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();
		boolean found[] = new boolean[256];// ASCII charecter set
		for(char c: A)found[c] = true;
		int count = 0;
		for(char c: B){
			if(found[c]){
				//previously found,so same charecter
				count++;
			}
		}
		if(count == B.length)System.out.println("Anagram");
		else System.out.println("Not an Anagram");
	}
	/** 
	 * Removes duplicate characters in string
	 * @param str
	 */
	public static void removeDuplicates(String str) {
		//the strings must not contain any white space
		char[] chars = str.toLowerCase().toCharArray();
		boolean found[] = new boolean[256];// ASCII charecter set
		for (int i = 0; i < str.length(); i++) {
			int val = chars[i];
			if (found[val]){
				//previously found make it blank
				chars[i] = ' ';
			}
			found[val] = true;
		}
		String newString = new String(chars);
		System.out.println(newString.replaceAll(" ",""));
	}

	public static boolean isAllUniqueChars2(String str) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			System.out.println(val);
			if (char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}
	/**
	 * A sequence of code with braces and symbols,will add braces where appropriate.
	 * We will use our stack here!
	 * @param str
	 * @throws Exception 
	 */
	public static void validateCode(String str) throws Exception{
		//arbitrary stack of capacity 100
		Stack<Character> codeStack = new Stack<Character>(100);
		int braceCount = 0;
		char[] source = str.toCharArray();
		for(char c: source){
			
			if(c == '{'){
				codeStack.push(c);
				++braceCount;
			}
			//previously found add it
			if(c == '}' && !codeStack.isEmpty()){
				--braceCount;
				while(!codeStack.isEmpty()){
					System.out.print(codeStack.pop());
				}
			}
			//previously not found add it
			if(c == '('){
				codeStack.push(c);
				++braceCount;
			}
			//previously found add it
			if(c == ')' && !codeStack.isEmpty()){
				--braceCount;
				while(!codeStack.isEmpty()){
					System.out.print(codeStack.pop());
				}
			}
			if(c != '{' && c!= '}' && c!= ')' && c!= '(')codeStack.push(c);
		}

		
	}
}
