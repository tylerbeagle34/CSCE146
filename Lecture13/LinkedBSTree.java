
public class LinkedBSTree <T extends Comparable<T>>{
	private class Node
	{
		private T data;
		private Node leftChild;
		private Node rightChild;
		public Node(T aData)
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
	public void insert(T aData)
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
	private Node insert(Node aNode, T aData) //Recursive insert
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
	public boolean search(T aData)
	{
		return search(root, aData);
	}
	private boolean search(Node aNode, T aData)
	{
		if(aNode == null) //Not found
		{
			return false;
		}
		if(aData.compareTo(aNode.data) == 0) //We found an instance
		{
			return true;
		}
		else if(aData.compareTo(aNode.data) < 0) //Go left
		{
			return search(aNode.leftChild, aData);
		}
		else
		{
			return search(aNode.rightChild, aData);
		}
	}
	public void printPreOrder()
	{
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
		printPreOrder(aNode.rightChild); //Recursive right
	}
	public void delete(T aData)
	{
		root = delete(root, aData);
	}
	private Node delete(Node aNode, T aData)
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
