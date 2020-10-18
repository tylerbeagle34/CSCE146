/*
 * Written by Warren Beagle
 * Homework07: Shape Tree
 * Front End
 */
public class ShapeTreeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeDatabase shapeDatabase = new ShapeDatabase(); //Instance of the shape database
		System.out.println("Welcome to the Shape Tree Tester \nReading from file");
		shapeDatabase.readShapeDBFile("./shapes.txt"); //Reads the shape file
		shapeDatabase.shapeTree.printPreOrder(); //Prints pre order
		shapeDatabase.shapeTree.printInOrder(); //Prints in order 
		shapeDatabase.shapeTree.printPostOrder(); //Prints post order
		shapeDatabase.shapeTree.findMaxInTree(); //Finds the max in the tree 
		shapeDatabase.shapeTree.delete(new Shape("Rectangle", 14.0)); //Deletes the specified shape
		shapeDatabase.shapeTree.printInOrder(); //Prints in order
		shapeDatabase.shapeTree.deleteGreaterThanValue(30.0); //Deletes shapes with an area greater than a specified value 
		shapeDatabase.shapeTree.printInOrder(); //Prints in order
	}

}
