/*
 * Written by Warren Beagle
 * Lab10: Fruit Tree
 * Front End 
 */
public class FruitTreeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FruitDatabase database = new FruitDatabase(); //Creates a new instance of the database 
		System.out.println("Welcome to the fruit tree! \nPopulating the tree from file");
		database.readFruitFile("./fruit.txt"); //Reads the fruit file and adds fruits to the tree
		database.fruitTree.printInOrder(); //Prints in order
		database.fruitTree.printPreOrder(); //Print pre order 
		database.fruitTree.printPostOrder(); //Print post order 
		database.fruitTree.delete(new Fruit("Apple", 0.4859853412170728)); //Deletes a specific fruit 
		database.fruitTree.printInOrder();
	}

}
