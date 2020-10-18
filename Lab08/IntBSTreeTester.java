/*
 * Written by Warren Beagle
 * Lab08: Tree of Integers!
 */
public class IntBSTreeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntBSTree<Integer> intTree = new IntBSTree<Integer>();
		//Insert 10 numbers
		System.out.println("Testing the tree \nInsterting 10 numbers");
		System.out.println("Inserting 8");
		intTree.insert(8);
		System.out.println("Inserting 13");
		intTree.insert(13);
		System.out.println("Inserting 3");
		intTree.insert(3);
		System.out.println("Inserting 4");
		intTree.insert(4);
		System.out.println("Inserting 18");
		intTree.insert(18);
		System.out.println("Inserting 19");
		intTree.insert(19);
		System.out.println("Inserting 10");
		intTree.insert(10);
		System.out.println("Inserting 1");
		intTree.insert(1);
		System.out.println("Inserting 9");
		intTree.insert(9);
		System.out.println("Inserting 2");
		intTree.insert(2);
		//Print the preoder traversal
		System.out.println("Printing Preorder Traversal");
		intTree.printPreorder();
		//Remove the number 4 and print preorder traversal
		System.out.println("Removing the number 4");
		intTree.remove(4);
		intTree.printPreorder();
		//Get the depth of 9
		intTree.getDepth(9);
		System.out.println("DONE!");
	}

}
