
public class ArrayBinHeap <T extends Comparable<T>>{
	private T[] heap;
	private int lastIndex = 0; //First null element in the heap
	public static final int DEFAULT_SIZE = 128;
	public ArrayBinHeap()
	{
		init(DEFAULT_SIZE);
	}
	public ArrayBinHeap(int size)
	{
		init(size);
	}
	private ArrayBinHeap(ArrayBinHeap heap)
	{
		
	}
	private void init(int size)
	{
		if(size > 0)
		{
			heap = (T[]) (new Comparable[size]);
		}
		lastIndex = 0;
	}
	public void insert(T aData)
	{
		if(lastIndex >= heap.length) //Heap is full
		{
			return;
		}
		heap[lastIndex] = aData;
		//bubble up
		bubbleUp();
		lastIndex++;
	}
	private void bubbleUp()
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
	public void heapSort()
	{
		//ArrayBinHeap heap2 = this;
		//T[] heap2 = heap;
		int index = lastIndex;
		for(int i = 0; i < index; i++)
		{
			System.out.println(this.remove());
		}
	}
}
