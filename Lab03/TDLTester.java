/*
 * Written by Warren Beagle
 * Lab 03: To Do List!
 * Driver
 */
public class TDLTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ToDoList list = new ToDoList();
		System.out.println("To Do List Tester! \nAdding Five Items To The List");
		//Adds items to the to do list
		list.addItem("Buy Ground Beef");
		list.addItem("Buy Cheese");
		list.addItem("Buy Taco Shells");
		list.addItem("Make Tacos");
		list.addItem("Eat Tacos");
		list.showList(); //Prints
		System.out.println("I Forgot To Get Salsa.  Let Me Add That After Step 2");
		list.goToNext(); //Moves current 1 element 
		list.insertAfterCurrent("Buy Salsa"); //Inserts new node after the current 
		list.showList(); //Prints
		System.out.println("On Second Thought I’m In A Spicy Mood So Let’s Change Salsa To Hot Sauce");
		list.goToNext(); //Moves current 1 element
		list.setDataAtCurrent("Buy Hot Sauce"); //Sets the data at the current node
		list.showList(); //Prints
		System.out.println("Do People Put Guacamole On Tacos? I’ll Add It After Step 3");
		list.insertAfterCurrent("Buy Guacamole"); //Inserts a new node after the current
		list.showList(); //Prints
		System.out.println("On Second Thought I Don’t Think They Do Let Me Take That Out");
		list.goToNext(); //Moves 1 element
		list.deleteCurrentNode(); //Deletes the current node
		list.showList(); //Prints
		System.out.println("We already have taco shells so we don't need to buy more");
		list.goToPrev();
		list.deleteCurrentNode();
		list.showList();
	}

}
