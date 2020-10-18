/*
 * Written by Warren Beagle
 * LabExam02: Practical Efficiency
 */
public class Sorter {
	//Variables
	private static int[] heap;
	private static int lastIndex;
	public static final int DEFAULT_SIZE = 10000;
	//Bubble Sort
	public static void bubbleSort(int[] a)
	{
		boolean hasSwapped = true;
		while(hasSwapped)
		{
			hasSwapped = false;
			for(int i = 0; i < a.length - 1; i++)
			{
				if(a[i] > a[i + 1]) //SWAP
				{
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					hasSwapped = true;
				}
			}
		}
	}
	//Merge Sort
	public static void mergeSort(int[] a)
	{
		int size = a.length;
		if(size < 2)
		{
			return;
		}
		int mid = size / 2;
		int leftSize = mid;
		int rightSize = size - mid;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		//Populate the left and right arrays
		for(int i = 0; i < left.length; i++)
		{
			left[i] = a[i];
		}
		for(int i = mid; i < size; i++)
		{
			right[i - mid] = a[i];
		}
		mergeSort(left); //Split left
		mergeSort(right); //Split right
		//Merge
		merge(left, right, a);
	}
	private static void merge(int[] left, int[] right, int[] a) //Merge helper method for mergeSort
	{
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0; //Index for the left array 
		int j = 0; //Index for the right array
		int k = 0; //Index for the merged array a
		while(i < leftSize && j < rightSize)
		{
			if(left[i] <= right[j])
			{
				a[k] = left[i];
				i++;
				k++;
			}
			else
			{
				a[k] = right[j];
				j++;
				k++;
			}
		}
		while(i < leftSize)
		{
			a[k] = left[i];
			i++;
			k++;
		}
		while(j < rightSize)
		{
			a[k] = right[j];
			j++;
			k++;
		}
	}
	//Heap Sort
	public static void heapSort(int[] a)
	{
		lastIndex = 0;
		heap = new int[DEFAULT_SIZE];
		for(int i = 0; i < a.length; i++)
		{
			insert(a[i]);
		}
		for(int i = 0; i < heap.length; i++)
		{
			remove();
		}
		for(int i = 0; i < heap.length; i++)
		{
			a[i] = heap[i];
		}
	}
	private static void insert(int a) //Insert method for heapSort
	{
		if(lastIndex >= heap.length) //Heap is full
		{
			return;
		}
		heap[lastIndex] = a;
		//bubble up
		bubbleUp();
		lastIndex++;
	}
	private static void bubbleUp() //bubbleUp helper method for insert
	{
		int currIndex = lastIndex; //Points to newly inserted element
		while(currIndex > 0 && heap[(currIndex - 1) / 2] > heap[currIndex])
		{
			//Swap
			int temp = heap[(currIndex - 1) / 2];
			heap[(currIndex - 1) / 2] = heap[currIndex];
			heap[currIndex] = temp;
			currIndex = (currIndex - 1) / 2;
		}
	}
	private static int remove() //remove method for heapSort
	{
		if(heap[0] == -1 || lastIndex == 0)
		{
			return -1;
		}
		int temp = heap[0];
		heap[0] = heap[lastIndex - 1];
		heap[lastIndex - 1] = -1; //Sets removed values to -1
		lastIndex --;
		bubbleDown();
		return temp;
	}
	private static void bubbleDown() //bubbleDown helper method for remove
	{
		int currIndex = 0;
		while(currIndex * 2 + 1 < lastIndex)
		{
			int bigIndex = currIndex * 2 + 1; //Assumes the left child is larger
			if(currIndex * 2 + 2 < lastIndex && heap[currIndex * 2 + 1] > heap[currIndex * 2 + 2]) //Right child was actually larger
			{
				bigIndex = currIndex * 2 + 2;
			}
			if(heap[currIndex] > heap[bigIndex])
			{
				//Swap
				int temp = heap[currIndex];
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
}
