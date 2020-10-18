/*
 * Written by Warren Beagle
 * Homework07: Shape Tree
 */
public class LinkedBSTree {
	private class Node
	{
		private Shape data;
		private Node leftChild;
		private Node rightChild;
		public Node(Shape aData)
		{
			data = aData;
			leftChild = rightChild = null;
		}
	}
	private Node root; //First element in the tree
	public LinkedBSTree()
	{
		root = null;
	}
	public void insert(Shape aData)
	{
		if(root == null)
		{
			root = new Node(aData);
		}
		else
		{
			insert(root, aData);
		}
	}
	private Node insert(Node aNode, Shape aData) //Recursive insert
	{
		if(aNode == null) //We found a leaf
		{
			aNode = new Node(aData);
		}
		else if(aData.compareTo(aNode.data) < 0) //Go left
		{
			aNode.leftChild = insert(aNode.leftChild, aData);
		}
		else if(aData.compareTo(aNode.data)  >= 0) //Go right
		{
			aNode.rightChild = insert(aNode.rightChild, aData);
		}
		return aNode;
	}
	public void printPreOrder()
	{
		System.out.println("\nPrinting pre order");
		printPreOrder(root);
	}
	private void printPreOrder(Node aNode)
	{
		if(aNode == null)
		{
			return;
		}
		System.out.println(aNode.data); //Access the node
		printPreOrder(aNode.leftChild); //Recursive left
		printPreOrder(aNode.rightChild); //Recursive right
	}
	public void printInOrder()
	{
		System.out.println("\nPrinting in order");
		printInOrder(root);
	}
	private void printInOrder(Node aNode)
	{
		if(aNode == null)
		{
			return;
		}
		printInOrder(aNode.leftChild); //Recursive left
		System.out.println(aNode.data); //Access the node
		printInOrder(aNode.rightChild); //Recursive right
	}
	public void printPostOrder()
	{
		System.out.println("\nPrinting post order");
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
		System.out.println(aNode.data); //Access the node
	}
	public void delete(Shape aData)
	{
		root = delete(root, aData);
	}
	private Node delete(Node aNode, Shape aData)
	{
		//Find the node
		if(aNode == null) //Value was not found in the tree
		{
			return null;
		}
		if(aData.compareTo(aNode.data) < 0) //Go left
		{
			aNode.leftChild = delete(aNode.leftChild, aData);
		}
		else if(aData.compareTo(aNode.data) > 0) //Go right
		{
			aNode.rightChild = delete(aNode.rightChild, aData);
		}
		else //Found it 
		{
			//We may or may not have a left child
			System.out.println("\nDeleting " + aNode.data);
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
	//Find the max in the tree
	public double findMaxInTree()
	{
		return findMaxInTree(root).data.getArea();
	}
	public Node findMaxInTree(Node aNode) //Recursive method to find the max
	{
		//Find a node
		if(aNode == null)
		{
			return null;
		}
		if(aNode.rightChild == null) //Goes until there are no more right children
		{
			System.out.println("\nThe max area is " + aNode.data.getArea());
			return aNode;
		}
		else
		{
			return findMaxInTree(aNode.rightChild); //Recursive call
		}
	}
	//Delete values greater than a specified value
	public void deleteGreaterThanValue(double anArea)
	{
		System.out.println("\nDeleting values greater than " + anArea);
		//Delete while the root is greater than an area
		while(root.data.getArea() > anArea)
		{
			delete(root.data);
		}
		deleteGreaterThanValue(root, anArea); //Recursive method
	}
	private void deleteGreaterThanValue(Node aNode, double anArea) //Recursive method to delete greater than value
	{
		//Find the node
		if(aNode == null) //Not found
		{
			return;
		}
		if(aNode.rightChild == null)
		{
			return;
		}
		if(anArea < aNode.rightChild.data.getArea()) //Found
		{
			aNode.rightChild = aNode.rightChild.leftChild;
		}
		deleteGreaterThanValue(aNode.rightChild, anArea); //Recursive call with the right child 
	}
}
