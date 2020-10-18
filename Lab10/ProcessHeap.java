/*
 * Written by Warren Beagle
 * Lab10: Process Heap
 */
public class ProcessHeap <Process extends Comparable<Process>>{
	private Process[] heap;
	private int size; //First null element in the heap
	public static final int DEFAULT_SIZE = 128;
	public ProcessHeap()
	{
		init(DEFAULT_SIZE);
	}
	public ProcessHeap(int size)
	{
		init(size);
	}
	private void init(int size)
	{
		if(size > 0)
		{
			heap = (Process[]) (new Comparable[size]);
		}
		size = 0;
	}
	//Insert
	public void insert(Process aProcess)
	{
		if(size >= heap.length) //Heap is full
		{
			return;
		}
		heap[size] = aProcess;
		//bubble up
		bubbleUp();
		size++;
	}
	private void bubbleUp()
	{
		int currIndex = size; //Points to newly inserted element
		while(currIndex > 0 && heap[(currIndex - 1) / 2].compareTo(heap[currIndex]) < 0)
		{
			//Swap
			Process temp = heap[(currIndex - 1) / 2];
			heap[(currIndex - 1) / 2] = heap[currIndex];
			heap[currIndex] = temp;
			currIndex = (currIndex - 1) / 2;
		}
	}
	//Peeks the top element of the heap
	public Process peek()
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
	//Delete
	public Process remove()
	{
		if(heap == null)
		{
			return null;
		}
		Process retVal = heap[0];
		heap[0] = heap[size - 1];
		heap[size - 1] = null;
		size--;
		//bubble down
		bubbleDown();
		return retVal;
	}
	private void bubbleDown()
	{
		int currIndex = 0;
		while(currIndex * 2 + 1 < size)
		{
			int bigIndex = currIndex * 2 + 1; //Assumes the left child is larger
			if(currIndex * 2 + 2 < size && heap[currIndex * 2 + 1].compareTo(heap[currIndex * 2 + 2]) < 0) //Right child was actually larger
			{
				bigIndex = currIndex * 2 + 2;
			}
			if(heap[currIndex].compareTo(heap[bigIndex]) < 0)
			{
				//Swap
				Process temp = heap[currIndex];
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
	//Prints the heap
	public void printHeap()
	{
		for(int i = 0; i < heap.length; i++)
		{
			if(heap[i] == null) //Doesn't print out null
			{
				return;
			}
			System.out.println(heap[i]);
		}
	}
	//isEmpty method
	public boolean isEmpty()
	{
		if(heap[0] == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	//Heap Sort
	public void heapSort()
	{
		//ArrayBinHeap heap2 = this;
		//Process[] heap2 = heap;
		int index = size;
		for(int i = 0; i < index; i++)
		{
			System.out.println(this.remove());
		}
	}
}
