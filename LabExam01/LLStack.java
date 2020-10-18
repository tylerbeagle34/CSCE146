/*
 * LabExam01: Enclosing Symbol Checker!
 * Written by Warren Beagle
 */
public class LLStack <T>{
	//Internal ListNode class
	private class ListNode
	{
		//Instance variables
		private T data;
		private ListNode link;
		//Constructor
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	//Instance variable
	private ListNode head;
	//Constructor
	public LLStack()
	{
		head = null;
	}
	//Stack methods
	public void push(T aData) //Pushes a new value onto the stack
	{
		ListNode newNode = new ListNode(aData, head);
		head = newNode;
	}
	public T pop() //Pops the last value of the stack off
	{
		if(head == null)
		{
			return null;
		}
		T ret = head.data;
		head = head.link;
		return ret;
	}
	public T peek() //Peeks at the value
	{
		if(head == null)
		{
			return null;
		}
		else
		{
			return head.data;
		}
	}
	public void print() //Prints the stack
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	public int count() //Counts the elements in the stack
	{
		int count = 0;
		ListNode temp = head;
		while(temp != null)
		{
			count ++;
			temp = temp.link;
		}
		return count;
	}
}