import com.dibosh.experiments.datastructures.ContainerExceptions;
import com.dibosh.experiments.datastructures.ContainerExceptions.EmptyException;
import com.dibosh.experiments.datastructures.ContainerExceptions.FullException;
import com.dibosh.experiments.datastructures.Queue;
import com.dibosh.experiments.datastructures.Stack;
import com.dibosh.experiments.interestingprobs.SmallInterestingProblem;


public class Main {

	
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testStack();
//		testQueue();
		//Algo tests
		SmallInterestingProblem.calculateSumForNumber(4678);
	}

}
