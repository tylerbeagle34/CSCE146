/*
 * Written by Warren Beagle
 * Homework02: Doubly Linked List
 */
public class GenDoubleLinkedList <T> {
	private class ListNode
	{
		private T data;
		private ListNode nextLink;
		private ListNode prevLink;
		public ListNode ()
		{
			data = null;
			nextLink = null;
			prevLink = null;
		}
		public ListNode(T aData, ListNode aNextLink, ListNode aPrevLink)
		{
			data = aData;
			nextLink = aNextLink;
			prevLink = aPrevLink;
		}
	}
	private ListNode head; //First element of our linked list
	private ListNode current; //Current element of interest
	public GenDoubleLinkedList()
	{
		head = null;
		current = head;
	}
	public void insert(T aData)
	{
		//Create the node 
		ListNode newNode = new ListNode(aData, null, null);
		if(head == null) //We have an empty list
		{
			head = newNode;
			current = head;
			return;
		}
		ListNode temp = head;
		while(temp.nextLink != null)
		{
			temp = temp.nextLink;
		}
		temp.nextLink = newNode;
	}
	//Moves current forward and allows current to be null
	public void goToNext()
	{
		if(current != null)
		{
			current.prevLink = current;
			current = current.nextLink;
		}
	}
	//Moves current backward
	public void goToPrev()
	{
		//TODO method to move backward
		ListNode temp = head; //Creates a new node
		if(temp.nextLink == current.prevLink)
		{
			current = temp; //Sets the current node to the temp node
			current.prevLink = temp.prevLink; //Sets the node one backward to the one behind the temp 
		}
		else
		{
			temp = temp.nextLink; //Sets the temp to the next node after the temp
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
	//Method for adding a new node after the current node
	public void insertNodeAfterCurrent(T aData)
	{
		ListNode newNode = new ListNode(aData, null, null); //Creates a new node
		if(current != null)
		{
			//Places the new node after the current node
			newNode.nextLink = current.nextLink;
			newNode.prevLink = current;
			current.nextLink = newNode;
		}
		//These statements are for other problems encountered when trying to add a new node after the current
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
		if(current != null && current.prevLink != null) //Current is somewhere in the middle
		{
			current = current.prevLink; //Sets the current to the previous
			current.nextLink = current.nextLink.nextLink; //Skips the one after the current ultimately deleting it
		}
		else if(current != null && current.prevLink == null) //Current and head are the same
		{
			head = current.nextLink; //Sets the head to the next node
			head = current; //Sets the new head to the current 
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
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.nextLink; //Move temp forward
		}
	}
	//Finds data within the list
	public boolean inList (T aData)
	{
		ListNode temp = head; //Start from the head
		while (temp != null)
		{
			if (temp.data == aData)
			{
				return true;
			}
			else
			{
				temp = temp.nextLink; //Move the temp forward
			}
		}
		return false;
	}
}
