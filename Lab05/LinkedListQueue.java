/*
 * Written by Warren Beagle
 * Lab05: Process Queue Simulator
 */
public class LinkedListQueue <T> {
	//Internal ListNode class
	private class ListNode
	{
		//Instance Variables
		T data;
		ListNode link;
		//Constructor
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	//Instance Variables
	ListNode head;
	ListNode tail;
	//Constructor
	public LinkedListQueue()
	{
		head = tail = null;
	}
	//Queue Methods
	public void enqueue(T aData)
	{
		ListNode newNode = new ListNode( aData, null);
		if(head == null) //queue is empty
		{
			head = newNode;
			tail = head;
			return;
		}
		tail.link = newNode;
		tail = tail.link;
	}
	public T dequeue()
	{
		if(head == null)
		{
			return null;
		}
		T ret = head.data;
		head = head.link;
		return ret;
	}
	public T peek()
	{
		if(head == null)
		{
			return null;
		}
		return head.data;
	}
	public void print()
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
}