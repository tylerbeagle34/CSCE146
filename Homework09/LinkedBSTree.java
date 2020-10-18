/*
 * Written by Warren Beagle
 * Lab10: Fruit Tree
 */
public class LinkedBSTree <Fruit extends Comparable<Fruit>>{
	private class Node
	{
		private Fruit fruit;
		private Node leftChild;
		private Node rightChild;
		public Node(Fruit aFruit)
		{
			fruit = aFruit;
			leftChild = rightChild = null;
		}
	}
	private Node root; //First element in the tree
	public LinkedBSTree()
	{
		root = null;
	}
	public void insert(Fruit aFruit)
	{
		if(root == null)
		{
			root = new Node(aFruit);
		}
		else
		{
			insert(root, aFruit);
		}
	}
	private Node insert(Node aNode, Fruit aFruit) //Recursive insert
	{
		if(aNode == null) //We found a leaf
		{
			aNode = new Node(aFruit);
		}
		else if(aFruit.compareTo(aNode.fruit) < 0) //Go left
		{
			aNode.leftChild = insert(aNode.leftChild, aFruit);
		}
		else if(aFruit.compareTo(aNode.fruit)  >= 0) //Go right
		{
			aNode.rightChild = insert(aNode.rightChild, aFruit);
		}
		return aNode;
	}
	public void printPreOrder()
	{
		System.out.println("\nPrinting pre order traversal");
		printPreOrder(root);
	}
	private void printPreOrder(Node aNode)
	{
		if(aNode == null)
		{
			return;
		}
		System.out.println(aNode.fruit); //Access the node
		printPreOrder(aNode.leftChild); //Recursive left
		printPreOrder(aNode.rightChild); //Recursive right
	}
	public void printInOrder()
	{
		System.out.println("\nPrinting in order traversal");
		printInOrder(root);
	}
	private void printInOrder(Node aNode)
	{
		if(aNode == null)
		{
			return;
		}
		printInOrder(aNode.leftChild); //Recursive left
		System.out.println(aNode.fruit); //Access the node
		printInOrder(aNode.rightChild); //Recursive right
	}
	public void printPostOrder()
	{
		System.out.println("\nPrinting post order traversal");
		printPostOrder(root);
	}
	public void printPostOrder(Node aNode)
	{
		if(aNode == null)
		{
			return;
		}
		printPostOrder(aNode.leftChild); //Recursive left
		printPostOrder(aNode.rightChild); //Recursive right
		System.out.println(aNode.fruit); //Access the node
	}
	public void delete(Fruit aFruit)
	{
		root = delete(root, aFruit);
	}
	private Node delete(Node aNode, Fruit aFruit)
	{
		//Find the node
		if(aNode == null) //Value was not found in the tree
		{
			return null;
		}
		if(aFruit.compareTo(aNode.fruit) < 0) //Go left
		{
			aNode.leftChild = delete(aNode.leftChild, aFruit);
		}
		else if(aFruit.compareTo(aNode.fruit) > 0) //Go right
		{
			aNode.rightChild = delete(aNode.rightChild, aFruit);
		}
		else //Found it 
		{
			//We may or may not have a left child
			System.out.println("\nDeleting " + aNode.fruit);
			if(aNode.rightChild == null) 
			{
				return aNode.leftChild;
			}
			//We do have a left child but not a right child
			if(aNode.leftChild == null)
			{
				return aNode.rightChild;
			}
			//We have two children
			Node temp = aNode; //Store soon to be deleted node
			aNode = findMinInTree(aNode.rightChild);
			aNode.rightChild = deleteMinFromTree(temp.rightChild);
			aNode.leftChild = temp.leftChild;
		}
		return aNode;
	}
	private Node findMinInTree(Node aNode)
	{
		if(aNode == null)
		{
			return null;
		}
		if(aNode.leftChild == null) //Last left child so it is the smallest
		{
			return aNode;
		}
		else //Recursively go left until the smallest is found
		{
			return findMinInTree(aNode.leftChild);
		}
	}
	private Node deleteMinFromTree(Node aNode)
	{
		if(aNode == null)
		{
			return null;
		}
		if(aNode.leftChild == null)
		{
			return aNode.rightChild;
		}
		aNode.leftChild = deleteMinFromTree(aNode.leftChild);
		return aNode;
	}
}
