
public class LLQueue <T> implements QueueInterface{
	private class ListNode
	{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	ListNode head;
	ListNode tail;
	public LLQueue()
	{
		head = tail = null;
	}
	public void enqueue(Object aData)
	{
		ListNode newNode = new ListNode((T)aData, null);
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
