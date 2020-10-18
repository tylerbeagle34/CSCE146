
public class IntLinkedList {
	private class ListNode
	{
		private int data;
		private ListNode link;
		public ListNode ()
		{
			data = 0;
			link = null;
		}
		public ListNode(int aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	private ListNode head; //First element of our linked list
	private ListNode curr; //Current element of interest
	private ListNode prev; //One node behind current
	public IntLinkedList()
	{
		head = curr = prev = null;
	}
	public void insert(int aData)
	{
		//Create new instance of a node
		ListNode newNode = new ListNode(aData, null);
		if(head == null) //List is empty so add to the first item
		{
			head = newNode;
			curr = head;
			return;
		}
		//We need to find the first null element
		ListNode temp = head;
		while(temp.link != null)
		{
			temp = temp.link;
		}
		temp.link = newNode; //Adds new element to the end of the list
	}
	public void print()
	{
		ListNode temp = head; //Start from head
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link; //Move temp forward
		}
	}
	//Accessor to the current node of interest
	public int getCurrent()
	{
		if(curr != null)
		{
			return curr.data;
		}
		else
		{
			return 0;
		}
	}
	//Mutator for the current node of interest
	public void setCurrent(int aData)
	{
		if(curr != null)
		{
			curr.data = aData;
		}
	}
	//Moves current forward and can go outside of the structure
	public void moveCurrentForward()
	{
		if(curr != null)
		{
			prev = curr;
			curr = curr.link;
		}
	}
	//Moves current and previous to beginning position
	public void resetCurrent()
	{
		curr = head; 
		prev = null;
	}
	//Insert after current
	public void insertAfterCurrent(int aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if(curr != null)
		{
			newNode.link = curr.link;
			curr.link = newNode;
		}
		else if(head != null)
		{
			System.out.println("Iterated outside of the list and cannot add");
		}
		else
		{
			System.out.println("The list is empty. Cannot insert into empty list");
		}
	}
	//Delete the current
	public void deleteCurrent()
	{
		if(curr != null && prev != null) //Current is somewhere in the middle
		{
			prev.link = curr.link;
			curr = curr.link;
		}
		else if(curr != null && prev == null) //Current and head are the same
		{
			head = head.link;
			curr = head;
		}
		else //Current for some reason is null
		{
			System.out.println("Can't delete an empty current");
		}
	}
}
