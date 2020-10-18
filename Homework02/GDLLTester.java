/*
 * Written by Warren Beagle
 * Homework02: Doubly Linked List
 * Driver
 */
public class GDLLTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenDoubleLinkedList<Integer> intList = new GenDoubleLinkedList<Integer>(); //Sets up the list of integers
		GenDoubleLinkedList<String> strList = new GenDoubleLinkedList<String>();
		for(int i = 0; i < 5; i++) //Populates the list
		{
			intList.insert(i + 1);
		}
		intList.showList(); //prints the list
		System.out.println();
		intList.goToNext(); //goes to next node int the list
		intList.insertNodeAfterCurrent(10); //inserts a new node after the current node
		intList.showList();
		System.out.println();
		intList.goToPrev(); //goes to the previous node
		intList.deleteCurrentNode(); //deletes the current node
		intList.showList();
		System.out.println();
		intList.goToNext();
		intList.deleteCurrentNode();
		intList.showList();
		System.out.println(intList.inList(1)); //Checks to see if 1 is in the list; should return false
		
		System.out.println();
		strList.insert("This");
		strList.insert("program");
		strList.insert("work");
		strList.showList();
		System.out.println();
		strList.goToNext(); //goes to next node int the list
		strList.insertNodeAfterCurrent("does"); //inserts a new node after the current node
		strList.showList();
		System.out.println();
		strList.goToPrev(); //goes to the previous node
		strList.deleteCurrentNode(); //deletes the current node
		strList.showList();
		System.out.println();
		strList.goToNext();
		strList.deleteCurrentNode();
		strList.showList();
		System.out.println(strList.inList("work")); //Checks to see if work is in the list; should return false
	}

}
