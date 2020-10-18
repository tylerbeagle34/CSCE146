/*
 * Written by Warren Beagle
 * Homework08: Jeep Heap
 */
public class JeepHeap <T extends Comparable<T>>{
	private T[] heap;
	private int lastIndex; //First null element in the heap
	public static final int DEFAULT_SIZE = 128;
	public static final int INSERT_INDEX = 15;
	public static final int REMOVE_INDEX = 5;
	public JeepHeap()
	{
		init(DEFAULT_SIZE);
	}
	public JeepHeap(int size)
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
	public void addJeep(T aJeep)
	{
		if(lastIndex >= heap.length) //Heap is full
		{
			return;
		}
		heap[lastIndex] = aJeep;
		//bubble up
		driveUp();
		lastIndex++;
	}
	private void driveUp()
	{
		int currIndex = lastIndex; //Points to newly inserted element
		while(currIndex > 0 && heap[(currIndex - 1) / 2].compareTo(heap[currIndex]) < 0)
		{
			//Swap
			T temp = heap[(currIndex - 1) / 2];
			heap[(currIndex - 1) / 2] = heap[currIndex];
			heap[currIndex] = temp;
			currIndex = (currIndex - 1) / 2;
		}
	}
	//Delete
	public T removeJeep()
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
		driveDown();
		return retVal;
	}
	private void driveDown()
	{
		int currIndex = 0;
		while(currIndex * 2 + 1 < lastIndex)
		{
			int bigIndex = currIndex * 2 + 1; //Assumes the left child is larger
			if(currIndex * 2 + 2 < lastIndex && heap[currIndex * 2 + 1].compareTo(heap[currIndex * 2 + 2]) < 0) //Right child was actually larger
			{
				bigIndex = currIndex * 2 + 2;
			}
			if(heap[currIndex].compareTo(heap[bigIndex]) < 0)
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
	//Heap Sort
	public void jeepHeapSort()
	{
		//ArrayBinHeap heap2 = this;
		//Jeep[] heap2 = heap;
		System.out.println("\nTesting Jeep Heap Sort");
		int index = lastIndex;
		for(int i = 0; i < index; i++)
		{
			System.out.println(this.removeJeep());
		}
	}
	//Peeks the top element of the heap
	public T peekJeep()
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
	//Prints the heap
	public void jeepRollCall()
	{
		System.out.println("Printing the Jeep heap");
		for(int i = 0; i < heap.length; i++)
		{
			if(heap[i] == null) //Doesn't print out null
			{
				return;
			}
			System.out.println(heap[i]);
		}
	}
}
