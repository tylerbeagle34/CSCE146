/*
 * Homework06: Sorting Comparison
 * Written by Warren Beagle
 */
import java.util.Random;
public class SortingComparison {
	public static final int ARRAY_SIZE = 1000; //Sets the array size
	public static final int TRIALS = 5; //Sets the number of trials being run
	//Instance variables for the different counts for each check
	public static int selectionCount;
	public static int bubbleCount;
	public static int mergeCount;
	public static int quickCount;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Instantiates a 4 new arrays (one for each sorting algorithm)
		int[] a1 = new int[ARRAY_SIZE];
		int[] a2 = new int[ARRAY_SIZE];
		int[] a3 = new int[ARRAY_SIZE];
		int[] a4 = new int[ARRAY_SIZE];
		Random r = new Random(); //Gets a random value between 0-999
		//Integer values to calculate the average at the end
		int totalSelection = 0;
		int totalBubble = 0;
		int totalMerge = 0;
		int totalQuick = 0;
		System.out.println("Performs each sort five times and takes the average checks for each at the end. \n");
		//Runs each of the different sorting algorithms 5 times with different arrays of integers
		for(int i = 0; i < TRIALS; i++)
		{
			System.out.println("Array " + (i + 1));
			for(int j = 0; j < ARRAY_SIZE; j++)
			{
				a1[j] = a2[j] = a3[j] = a4[j] = r.nextInt(ARRAY_SIZE); //Populates the different arrays with the same values
			}
			//Set the counts to 0
			selectionCount = 0;
			bubbleCount = 0;
			mergeCount = 0;
			quickCount = 0;
			//Run Selection Sort
			System.out.println("Performing Selection Sort on the array");
			selectionSort(a1);
			totalSelection += selectionCount; //Add to the total count
			for(int j = 0; j < ARRAY_SIZE; j++)
			{
				System.out.print(a1[j] + " "); //Print the sorted array
			}
			System.out.println();
			System.out.println("Number of Checks: " + selectionCount); //Prints the number of checks
			//Run bubble sort
			System.out.println("\nPerforming Bubble Sort on the array");
			bubbleSort(a2);
			totalBubble += bubbleCount; //Add to the total count
			for(int j = 0; j < ARRAY_SIZE; j++)
			{
				System.out.print(a2[j] + " "); //Print the sorted array
			}
			System.out.println();
			System.out.println("Number of Checks: " + bubbleCount); //Prints the number of checks
			//Run Merge Sort
			System.out.println("\nPerforming Merge Sort on the array");
			mergeSort(a3);
			totalMerge += mergeCount; //Adds to the total count
			for(int j = 0; j < ARRAY_SIZE; j++)
			{
				System.out.print(a3[j] + " "); //Prints the sorted array
			}
			System.out.println();
			System.out.println("Number of Checks: " + mergeCount); //Prints the number of checks
			//Run Quick Sort
			System.out.println("\nPerforming Quick Sort on the array");
			quickSort(a4, (a4.length - a4.length), a4.length - 1);
			totalQuick += quickCount; //Adds to the total count
			for(int j = 0; j < ARRAY_SIZE; j++)
			{
				System.out.print(a4[j] + " "); //Print the sorted array
			}
			System.out.println();
			System.out.println("Number of Checks: " + quickCount); //Print the number of checks
			System.out.println();
		}
		//Print the average number of checks using the total count for each of the sorts
		System.out.println("Average number of checks in selection sort: " + totalSelection / TRIALS);
		System.out.println("Average number of checks in bubble sort: " + totalBubble / TRIALS);
		System.out.println("Average number of checks in merge sort: " + totalMerge / TRIALS);
		System.out.println("Average number of checks in quick sort: " + totalQuick / TRIALS);
	}
	//Selection Sort
	public static void selectionSort(int[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			int smallestIndex = i;
			for(int j = i + 1; j < a.length; j++)
			{
				if(a[j] < a[smallestIndex]) //True if found a smaller value
				{
					smallestIndex = j;
				}
				selectionCount++; //Adds to the selection count
			}
			if(smallestIndex != i) //Need to swap
			{
				int temp = a[i];
				a[i] = a[smallestIndex];
				a[smallestIndex] = temp;
				selectionCount++; //Adds to the selection count
			}
		}
	}
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
				bubbleCount++; //Adds to the bubble count
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
	private static void merge(int[] left, int[] right, int[] a)
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
			mergeCount++; //Adds to the merge count
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
	//Quick Sort
	public static void quickSort(int[] a, int leftIndex, int rightIndex)
	{
		//partition
		int index = partition(a, leftIndex, rightIndex);
		if(leftIndex < index - 1)
		{
			quickSort(a, leftIndex, index - 1); //New quick sort
		}
		if(index < rightIndex)
		{
			quickSort(a, index, rightIndex); //New quick sort
		}
	}
	private static int partition(int[] a, int leftIndex, int rightIndex)
	{
		int i = leftIndex;
		int j = rightIndex;
		int pivot = a[(leftIndex + rightIndex) / 2];
		while(i <= j)
		{
			while(a[i] < pivot)
			{
				i++; //Changes the pivot 
			}
			while(a[j] > pivot)
			{
				j--; //Changes the pivot
			}
			if(i <= j) //Found elements out of order so swap
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
				quickCount++; //Adds to the quick count
			}
		}
		return i; //Returns i
	}
}
