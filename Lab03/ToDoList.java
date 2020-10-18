/*
 * Written by Warren Beagle
 * Lab03: To Do List!
 */
public class ToDoList {
	//Internal Class
	private class ListNode
	{
		//Instance variables
		private String data;
		private ListNode link;
		//Constructors
		public ListNode() //Default
		{
			data = "no data";
			link = null;
		}
		public ListNode(String aData, ListNode aLink) //Parameterized
		{
			data = aData;
			link = aLink;
		}
	}
	//Instance variables
	private ListNode head; //First element of our linked list
	private ListNode current; //Current element of interest
	private ListNode previous; //One node behind current
	//Constructor
	public ToDoList()
	{
		head = current = previous = null;
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
	public String getDataAtCurrent()
	{
		if(current != null)
		{
			return current.data;
		}
		else
		{
			return "no data";
		}
	}
	//Mutator for the current node of interest
	public void setDataAtCurrent(String aData)
	{
		if(current != null)
		{
			current.data = aData;
		}
	}
	//Add item 
	public void addItem(String aData)
	{
		//Create new instance of a node
		ListNode newNode = new ListNode(aData, null);
		if(head == null) //List is empty so add to the first item
		{
			head = newNode;
			current = head;
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
	//Insert after current
	public void insertAfterCurrent(String aData)
	{
		ListNode newNode = new ListNode(aData, null);
		if(current != null)
		{
			newNode.link = current.link;
			current.link = newNode;
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
			previous.link = current.link;
			current = current.link;
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
		int i = 1;
		ListNode temp = head; //Start from head
		System.out.println("Printing List");
		while(temp != null)
		{
			System.out.println(i + ". " + temp.data);
			i++;
			temp = temp.link; //Move temp forward
		}
	}
}
