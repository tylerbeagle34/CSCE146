/*
 * Written by Warren Beagle
 * Lab04: Circular Linked List
 */
public class GenCircularLinkedList <T>{
	//Internal Class
	private class ListNode
	{
		//Instance variables
		private T data;
		private ListNode link;
		//Constructors
		public ListNode() //Default
		{
			data = null;
			link = null;
		}
		public ListNode(T aData, ListNode aLink) //Parameterized
		{
			data = aData;
			link = aLink;
		}
	}
	//Instance variables
	private ListNode head; //First element of our linked list
	private ListNode current; //Current element of interest
	private ListNode previous; //One node behind current
	private ListNode tail; //Last element of our linked list; points to the head
	//Constructor
	public GenCircularLinkedList()
	{
		head = current = previous = tail = null;
	}
	//Moves current forward and can go outside of the structure
	public void goToNext()
	{
		if(current != null)
		{
			previous = current;
			current = current.link;
		}
	}
	//Moves current backward
	public void goToPrev()
	{
		//TODO method to move backward
		ListNode temp = head;
		if(temp.link == previous)
		{
			current = previous;
			previous = temp;
		}
		else
		{
			temp = temp.link;
		}
	}
	//Accessor to the current node of interest
	public T getDataAtCurrent()
	{
		if(current != null)
		{
			return current.data;
		}
		else
		{
			return null;
		}
	}
	//Mutator for the current node of interest
	public void setDataAtCurrent(T aData)
	{
		if(current != null)
		{
			current.data = aData;
		}
	}
	//Add item 
	public void insert(T aData)
	{
		//Create new instance of a node
		ListNode newNode = new ListNode(aData, null);
		if(head == null) //List is empty so add to the first item
		{
			head = newNode;
			current = head;
			tail = head;
			return;
		}
		//We need to find the first null element
		ListNode temp = head;
		while(temp != tail)
		{
			temp = temp.link;
		}
		temp.link = newNode; //Adds new element to the end of the list
		tail = newNode;
		tail.link = head;
	}
	//Insert after current
	public void insertNodeAfterCurrent(T aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if(current != null)
		{
			if(current == tail)
			{
				newNode.link = current.link;
				current.link = newNode;
				tail = newNode;
				tail.link = head;
			}
			else
			{
				newNode.link = current.link;
				current.link = newNode;
			}
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
	//Delete the current node
	public void deleteCurrentNode()
	{
		if(current != null && previous != null) //Current is somewhere in the middle
		{
			if(current == head)
			{
				tail.link = current.link;
				current = current.link;
				head = current;
			}
			else
			{
				previous.link = current.link;
				current = current.link;
			}
		}
		else if(current != null && previous == null) //Current and head are the same
		{
			head = head.link;
			current = head;
		}
		else //Current for some reason is null
		{
			System.out.println("Can't delete an empty current");
		}
	}
	//Print
	public void showList()
	{
		ListNode temp = head; //Start from head
		System.out.print(temp.data + "\n");
		temp = temp.link;
		while(temp != tail.link)
		{
			System.out.println(temp.data);
			temp = temp.link; //Move temp forward
		}
	}
	//Finds data within the list
	public boolean inList (T aData)
	{
		ListNode temp = head; //Start from the head
		if(temp.data == aData)
		{
			return true;
		}
		else
		{
			temp = temp.link;
		}
		while (temp != tail.link)
		{
			if (temp.data == aData)
			{
				return true;
			}
			else
			{
				temp = temp.link; //Move the temp forward
			}
		}
		return false;
	}
}
