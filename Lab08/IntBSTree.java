/*
 * Written by Warren Beagle
 * Lab08: Tree of Integers!
 */
public class IntBSTree <Integer extends Comparable <Integer>>{
	int count = 0;
	private class Node
	{
		private int data;
		private Node leftChild;
		private Node rightChild;
		public Node(int aData)
		{
			data = aData;
			leftChild = rightChild = null;
		}
	}
	private Node root; //First element in the tree
	public IntBSTree()
	{
		root = null;
	}
	public void insert(int aData)
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
	private Node insert(Node aNode, int aData) //Recursive insert
	{
		if(aNode == null) //We found a leaf
		{
			aNode = new Node(aData);
		}
		else if(aData - aNode.data < 0) //Go left
		{
			aNode.leftChild = insert(aNode.leftChild, aData);
		}
		else if(aData - aNode.data  >= 0) //Go right
		{
			aNode.rightChild = insert(aNode.rightChild, aData);
		}
		return aNode;
	}
	public void remove(int aData)
	{
		root = remove(root, aData);
	}
	private Node remove(Node aNode, int aData)
	{
		//Find the node
		if(aNode == null) //Value was not found in the tree
		{
			return null;
		}
		if(aData - aNode.data < 0) //Go left
		{
			aNode.leftChild = remove(aNode.leftChild, aData);
		}
		else if(aData - aNode.data > 0) //Go right
		{
			aNode.rightChild = remove(aNode.rightChild, aData);
		}
		else //Found it 
		{
			//We may or may not have a left child
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
			aNode.rightChild = removeMinFromTree(temp.rightChild);
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
	private Node removeMinFromTree(Node aNode)
	{
		if(aNode == null)
		{
			return null;
		}
		if(aNode.leftChild == null)
		{
			return aNode.rightChild;
		}
		aNode.leftChild = removeMinFromTree(aNode.leftChild);
		return aNode;
	}
	public void printPreorder()
	{
		printPreorder(root);
	}
	private void printPreorder(Node aNode)
	{
		if(aNode == null)
		{
			return;
		}
		System.out.println(aNode.data); //Access the node
		printPreorder(aNode.leftChild); //Recursive left
		printPreorder(aNode.rightChild); //Recursive right
	}
	public void getDepth(int aData)
	{
		getDepth(root, aData);
	}
	public Node getDepth(Node aNode, int aData)
	{
		if(aNode == null)
		{
			System.out.println("The depth of " + aData + " is -1");
			return null;
		}
		if(aData - aNode.data < 0)
		{
			count++;
			getDepth(aNode.leftChild, aData);
		}
		else if(aData - aNode.data > 0)
		{
			count++;
			getDepth(aNode.rightChild, aData);
		}
		else
		{
			System.out.println("The depth of " + aData + " is " + count);
		}
		return aNode;
	}
}
