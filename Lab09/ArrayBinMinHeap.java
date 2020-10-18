/*
 * Written by Warren Beagle
 * Lab09: Min Heap of Integers!
 */
public class ArrayBinMinHeap <T extends Comparable<T>>{
	private T[] heap;
	private int lastIndex; //First null element in the heap
	public static final int DEFAULT_SIZE = 128;
	public ArrayBinMinHeap()
	{
		init(DEFAULT_SIZE);
	}
	public ArrayBinMinHeap(int size)
	{
		init(size);
	}
	private void init(int size)
	{
		if(size > 0)
		{
			heap = (T[]) (new Comparable[size]);
		}
		lastIndex = 0;
	}
	//Insert 
	public void insert(T aData)
	{
		if(lastIndex >= heap.length) //Heap is full
		{
			return;
		}
		System.out.println(aData);
		heap[lastIndex] = aData;
		//bubble up
		bubbleUp();
		lastIndex++;
	}
	private void bubbleUp()
	{
		int currIndex = lastIndex; //Points to newly inserted element
		while(currIndex > 0 && heap[(currIndex - 1) / 2].compareTo(heap[currIndex]) > 0)
		{
			//Swap
			T temp = heap[(currIndex - 1) / 2];
			heap[(currIndex - 1) / 2] = heap[currIndex];
			heap[currIndex] = temp;
			currIndex = (currIndex - 1) / 2;
		}
	}
	//Remove
	public T remove()
	{
		if(heap == null)
		{
			return null;
		}
		T retVal = heap[0];
		heap[0] = heap[lastIndex - 1];
		heap[lastIndex - 1] = null;
		lastIndex--;
		//bubble down
		bubbleDown();
		return retVal;
	}
	private void bubbleDown()
	{
		int currIndex = 0;
		while(currIndex * 2 + 1 < lastIndex)
		{
			int bigIndex = currIndex * 2 + 1; //Assumes the left child is larger
			if(currIndex * 2 + 2 < lastIndex && heap[currIndex * 2 + 1].compareTo(heap[currIndex * 2 + 2]) > 0) //Right child was actually larger
			{
				bigIndex = currIndex * 2 + 2;
			}
			if(heap[currIndex].compareTo(heap[bigIndex]) > 0)
			{
				//Swap
				T temp = heap[currIndex];
				heap[currIndex] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
			else
			{
				break;
			}
			currIndex = bigIndex;
		}
	}
	/*public void heapSort()
	{
		//ArrayBinMinHeap heap2 = this;
		//T[] heap2 = heap;
		int index = lastIndex;
		for(int i = 0; i < index; i++)
		{
			System.out.print(this.remove() + " ");
		}
	}*/
	//Peek the top element of the heap
	public T peek()
	{
		if(heap == null)
		{
			return null;
		}
		else
		{
			return heap[0];
		}
	}
	//Print the heap
	public void print()
	{
		System.out.println("Printing Heap");
		for(int i = 0; i < heap.length; i++)
		{
			if(heap[i] == null)
			{
				return; //Doesn't print out nulls
			}
			System.out.println(heap[i]);
		}
	}
}
