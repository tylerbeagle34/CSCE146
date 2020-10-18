
public class GenLinkedList <T>{
	private class ListNode
	{
		private T data;
		private ListNode link;
		public ListNode()
		{
			data = null;
			link = null;
		}
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	ListNode head; //First element in the linked list
	ListNode curr; //Used outside of the structure to get and set data
	ListNode prev; //One node behind current
	public GenLinkedList()
	{
		head = curr = prev = null;
	}
	//Inserts new item at the end of the list
	public void insert(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if(head == null) //Empty list
		{
			head = newNode;
			return;
		}
		//Not an empty list
		ListNode temp = head;
		while(temp.link != null)
		{
			temp = temp.link;
		}
		temp.link = newNode;
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
	//Kind of getter
	public T getCurrent()
	{
		if(curr != null)
		{
			return curr.data;
		}
		else
		{
			return null;
		}
	}
	//Kind of setter
	public void setCurrent(T aData)
	{
		if(curr != null)
		{
			curr.data = aData;
		}
	}
	public void moveCurrentForward()
	{
		if(curr != null)
		{
			prev = curr;
			curr = curr.link;
		}
	}
	public void resetCurrent()
	{
		prev = null;
		curr = head;
	}
	public boolean moreToIterate()
	{
		return curr != null;
	}
	public void insertAfterCurrent(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if(curr != null)
		{
			newNode.link = curr.link;
			curr.link = newNode;
		}
	}
	public void deleteCurrent()
	{
		if(curr.link == null)
		{
			curr = null;
			prev.link = null;
		}
		else if(curr != null && prev != null) //Current is not head and in the middle
		{
			prev.link = curr.link;
			curr = curr.link;
		}
		else if(curr != null && prev == null) //Current is the head
		{
			head = head.link;
			curr = head;
		}
	}
}
