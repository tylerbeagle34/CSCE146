
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
	private ListNode head; //First element in our list
	private ListNode curr; //Current node of interest
	private ListNode prev; //One node behind the current
	public GenLinkedList()
	{
		head = curr = prev = null;
	}
	//Insert to the end of the list
	public void insert(T aData)
	{
		//Create the node 
		ListNode newNode = new ListNode(aData, null);
		if(head == null) //We have an empty list
		{
			head = newNode;
			curr = head;
			return;
		}
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
	//Sort of like an accessor
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
	//Sort of like a mutator
	public void setCurrent(T aData)
	{
		if(curr != null)
		{
			curr.data = aData;
		}
	}
	//Moves current forward and allows current to be null
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
		curr = head;
		prev = null;
	}
	//Insert after current
	public void insertAfterCurrent(T aData)
	{
		//Create the node
		ListNode newNode = new ListNode(aData, null);
		if(curr != null)
		{
			newNode.link = curr.link;
			curr.link = newNode;
		}
		else if(head != null)
		{
			System.out.println("Current is outside of the list");
		}
		else
		{
			System.out.println("The list is empty and cannot be added");
		}
	}
	public void deleteCurrent()
	{
		if(curr != null && prev != null) //Current is somewhere in the list
		{
			prev.link = curr.link; //Previous skips over the current
			curr = curr.link;
		}
		else if(curr != null && prev == null) //Current is at the head
		{
			head = curr.link; //head.link is the same thing
			curr = head;
		}
		else //Current is null
		{
			System.out.println("Can't delete something that does not exist");
		}
	}
}
