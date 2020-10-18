/*
 * Written by Warren Beagle
 * Lab04: Circular Linked List
 * Driver
 */
public class GCLLTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenCircularLinkedList<Integer> intList = new GenCircularLinkedList<Integer>(); //Sets up the list of integers
		System.out.println("Generic Circular Linked List Tester\n");
		System.out.println("Create, insert, and print test by adding values 1-4");
		for(int i = 0; i < 4; i ++)
		{
			intList.insert(i + 1); //Populates the list
		}
		intList.showList(); //Prints the list
		System.out.println("\nMoving current twice and deleting the current");
		intList.goToNext(); //Goes to the next element in the list
		intList.goToNext();
		intList.deleteCurrentNode(); //Deletes the current node
		intList.showList();
		System.out.println("\nTesting In list by searching for the value 4");
		System.out.println(intList.inList(4)); //Tests to see if the value is in the list
		System.out.println("\nTesting In list by searching for the value 3");
		System.out.println(intList.inList(3));
		System.out.println("\nTesting getting and setting current by adding the value 10 to the current data.");
		intList.setDataAtCurrent(intList.getDataAtCurrent() + 10); //Sets the data at the current to a different value
		intList.showList();
		System.out.println("\nMoving current forward and deleting that node");
		intList.goToNext();
		intList.deleteCurrentNode();
		intList.showList();
		System.out.println("\nMoving current backward and deleting that node");
		intList.goToPrev(); //Goes to the previous node
		intList.deleteCurrentNode();
		intList.showList();
		System.out.println("\nTest Done");
	}

}
