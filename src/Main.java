import java.util.Random;

import com.dibosh.experiments.datastructures.ContainerExceptions;
import com.dibosh.experiments.datastructures.ContainerExceptions.EmptyException;
import com.dibosh.experiments.datastructures.ContainerExceptions.FullException;
import com.dibosh.experiments.datastructures.ContainerExceptions.NotFoundException;
import com.dibosh.experiments.datastructures.IntegerStack;
import com.dibosh.experiments.datastructures.Queue;
import com.dibosh.experiments.datastructures.SinglyLinkedList;
import com.dibosh.experiments.datastructures.Stack;
import com.dibosh.experiments.interestingprobs.SmallInterestingProblem;


public class Main {

	static void testIntegerStack(){
		IntegerStack inst = new IntegerStack(10);
		Random rnd = new Random();
		for(int i =0 ;i < 5;i++){
			inst.push(rnd.nextInt(1024));
		}
		
		inst.print();
		
		System.out.println("Min:"+inst.min()+" Max:"+inst.max());
	}
	static void testStack(){
		int size = 10;
		Stack<Integer> st = new Stack<Integer>(size);
		//try inserting until size+1,you should get a fullcontainer exception
		
		for(int i=0;i<4;i++){
			try {
				st.push(i);
			} catch (ContainerExceptions.FullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		st.print();
		try {
			System.out.println(st.top());
			st.print();
			System.out.println(st.pop());
			st.print();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void testQueue(){
		String strings[] = {"my","name","is","khan"};
		
		Queue<String> q = new Queue<String>(strings.length);
//		testing exceptions
//		try {
//			q.dequeue();
//			q.first();
//		} catch (EmptyException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		for(String s: strings){
			try {
				q.enequeue(s);
			} catch (FullException e) {
				e.printStackTrace();
			}
		}
		
		q.print();
		
		try {
			q.dequeue();
//			q.dequeue();
//			System.out.println(q.first());
		} catch (EmptyException e) {
			e.printStackTrace();
		}
		
		q.print();
		
	}
	
	static void testList(){
		SinglyLinkedList<Integer> list =new SinglyLinkedList<Integer>();
		for(int i=0;i<44;i++){
			list.add(i);
		}
		list.print();
		
		System.out.println("Size:"+list.size());
		
		System.out.println("Removing "+43);
		
		try {
			list.remove(43);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list.print();
		
		System.out.println("Adding "+22);
		
		list.add(22);
		
		list.print();
		
		System.out.println("Replacing "+32+" by "+1024);
		
		try {
			list.replace(32, 1024);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list.print();
		
		System.out.println("Inserting "+2048+" after "+10);
		
		try {
			list.insertAfter(10, 20148);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list.print();
		
		SinglyLinkedList<String> stringList = new SinglyLinkedList<String>();
		String[] array = {"a","b","c","d","e","c","b"};
		stringList.addAll(array);
		stringList.print();
		stringList.removeDuplicates();
		stringList.print();
	}
	static void testUniqueness(boolean flag){
		if(flag)System.out.println("Unique");
		else System.out.println("Not unique");
	}
	private static void testTOH() {
		Stack<Integer> pileA = new Stack<Integer>(5);
		Stack<Integer> pileB = new Stack<Integer>(5);
		Stack<Integer> pileC = new Stack<Integer>(5);
		pileA.setLabel("A");
		pileB.setLabel("B");
		pileC.setLabel("C");
		for(int i=1;i<=3;i++){
			try {
				pileA.push(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			SmallInterestingProblem.solveTowerOfHanoy(pileA, pileC, pileB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// UNCOMMENT ANYTHING TO TEST THAT PART
//		testStack();
//		testQueue();
		//Algo tests
//		SmallInterestingProblem.calculateSumForNumber(4678);
//		SmallInterestingProblem.printReverse("hello guys".toCharArray());
//		testUniqueness(SmallInterestingProblem.isAllUniqueChars("hello"));
//		testUniqueness(SmallInterestingProblem.isAllUniqueChars("amr dhon beku"));
//		SmallInterestingProblem.removeDuplicates("abcd");
//		SmallInterestingProblem.removeDuplicates("aaaa");
//		SmallInterestingProblem.removeDuplicates("aaabbb");
//		SmallInterestingProblem.removeDuplicates("abababa");
		
//		SmallInterestingProblem.anagram("silence","license");
//		SmallInterestingProblem.replaceSpacesWith("my name is khan", "%20");
		
//		try {
//			SmallInterestingProblem.validateCode("{a+(b*c)+{k*l}}");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		testList();
		
//		testIntegerStack();
		testTOH();
		
	}
	

}
