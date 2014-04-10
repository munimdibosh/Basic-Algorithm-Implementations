package com.dibosh.experiments.interestingprobs;

public class SmallInterestingProblem {

	/**
	 * This is interesting. Suppose a number is 1476,the summation of all 
	 * the digits is 18 and now if we sum up the digits we get 9 which is smaller
	 * than 10. This program does exactly this,given a number 'n' it will keep showing
	 * the sum of it's digits until it gets smaller than 10!
	 * @param n
	 */
	public static void calculateSumForNumber(int n){
		int sum = 0;
		int divident = n;
		int divider = 10;
		int mod;
		do{
			while(divident != 0){
				mod = divident%divider;
				divident = divident/divider;
				sum+= mod;
			}
			divident = sum;
			System.out.println("Number:"+sum);
			sum = 0;
		}while(divident >= 10);
	}
}
