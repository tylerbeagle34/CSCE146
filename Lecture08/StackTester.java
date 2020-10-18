import java.util.*;
public class StackTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackInterface<Integer> stack = new LLStack<Integer>();
		for(int i = 0; i < 10; i ++)
		{
			stack.push(i);
		}
		stack.print();
		System.out.println("Pop the stack " + stack.pop());
		stack.print();
		//Built in java stack
		Stack<Integer> iStack = new Stack<Integer>();
	}

}
