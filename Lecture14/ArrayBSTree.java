
public class ArrayBSTree <T extends Comparable<T>> {
	private T[] tree;
	public static final int DEFAULT_SIZE = 128;
	public ArrayBSTree()
	{
		init(DEFAULT_SIZE);
	}
	public ArrayBSTree(int size)
	{
		init(size);
	}
	public void init(int size)
	{
		if(size > 0)
		{
			tree = (T[]) (new Comparable[size]);
		}
	}
	public void insert(T aData)
	{
		if(tree[0] == null)
		{
			tree[0] = aData;
		}
		else
		{
			insert(0, aData);
		}
	}
	private void insert(int index, T aData)
	{
		if(tree[index] == null)
		{
			tree[index] = aData;
		}
		else if(aData.compareTo(tree[index]) < 0 && index * 2 + 1 < tree.length) //Go left
		{
			insert(index * 2 + 1, aData);
		}
		else if(aData.compareTo(tree[index]) >= 0 && index * 2 + 2 < tree.length) //Go right
		{
			insert(index * 2 + 2, aData);
		}
	}
	public boolean search(T aData)
	{
		return search(0, aData);
	}
	private boolean search(int index, T aData)
	{
		if(index >= tree.length)
		{
			return false;
		}
		if(tree[index] == null)
		{
			return false;
		}
		else if(aData.compareTo(tree[index]) == 0) //Found it 
		{
			return true;
		}
		else if(aData.compareTo(tree[index]) < 0) //Go left
		{
			return search(index * 2 + 1, aData);
		}
		else //Go right
		{
			return search(index * 2 + 2, aData);
		}
	}
	public void printBreadthOrder()
	{
		for(T val : tree)
		{
			if(val != null)
			{
				System.out.println(val);
			}
			else
			{
				System.out.println("null");
			}
		}
	}
	public void delete(T aData)
	{
		delete(0, aData);
	}
	public void delete(int index, T aData)
	{
		//data wasn't found or went out of bounds so still it wasn't found
		if(index >= tree.length || tree[index] == null)
		{
			return;
		}
		if(aData.compareTo(tree[index]) < 0) //Go left
		{
			delete(index * 2 + 1, aData);
		}
		else if(aData.compareTo(tree[index]) > 0) //Go right
		{
			delete(index * 2 + 2, aData);
		}
		else //Found it 
		{
			//May have no children or a left child
			if(index * 2 + 2 < tree.length && tree[index * 2 + 2] == null)
			{
				moveLeftSubtree(index);
			}
			else if(index * 2 + 2 < tree.length && tree[index * 2 + 1] == null)
			{
				moveRightSubtree(index);
			}
			//It has two children
		}
	}
	private void moveRightSubtree(int index)
	{
		if(index >= tree.length)
		{
			return;
		}
		boolean isLeft = index % 2 != 0;
		if(!isLeft || index == 0)
		{
			if(index * 2 + 2 < tree.length)
			{
				tree[index] = tree[index * 2 + 2];
			}
			else
			{
				tree[index] = null;
				return;
			}
		}
		else
		{
			if((index + 1) * 2 + 1 < tree.length)
			{
				tree[index] = tree[(index + 1) * 2 + 1];
			}
			else
			{
				tree[index] = null;
				return;
			}
		}
		moveRightSubtree(index * 2 + 1);
		moveRightSubtree(index * 2 + 2);
	}
	private void moveLeftSubtree(int index)
	{
		if(index >= tree.length)
		{
			return;
		}
		boolean isLeft = index % 2 != 0; //All left children are odd
		if(isLeft || index == 0)
		{
			if(index * 2 + 1 < tree.length)
			{
				tree[index] = tree[index * 2 + 1];
			}
			else
			{
				tree[index] = null;
				return;
			}
		}
		else
		{
			if((index - 1) * 2 + 2 < tree.length)
			{
				tree[index] = tree[(index - 1) * 2 + 2];
			}
			else
			{
				tree[index] = null;
				return;
			}
		}
		moveLeftSubtree(index * 2 + 1);
		moveLeftSubtree(index * 2 + 2);
	}
}	
