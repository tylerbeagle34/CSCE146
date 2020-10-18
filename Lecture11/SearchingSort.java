import java.util.*;
public class SearchingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] a = new int[32];
		Random r = new Random(100);
		for(int i = 0; i < a.length; i++)
		{
			a[i] = r.nextInt(100);
		}
		/*System.out.println(linearSearchIter(a, 4));
		System.out.println(linearSearchIter(a, 19));*/
		selectionSort(a);
	}
	public static boolean linearSearchIter(int[] a, int val)
	{
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] == val)
			{
				return true;
			}
		}
		return false;
	}
	public static boolean linearSearchRecur(int[] a, int val, int currIndex)
	{
		if(a[currIndex] == val)
		{
			return true;
		}
		currIndex++;
		if(currIndex >= a.length)
		{
			return false;
		}
		else
		{
			return linearSearchRecur(a, val, currIndex);
		}
	}
	public static boolean binarySearchRecur(int[] a, int val, int minIndex, int maxIndex)
	{
		if(minIndex > maxIndex) //The value was not found
		{
			return false;
		}
		int midIndex = (maxIndex + minIndex) / 2;
		if(a[midIndex] == val) //Found the value
		{
			return true;
		}
		if(val > a[midIndex]) //Look in the top half of the array
		{
			return binarySearchRecur(a, val, midIndex + 1, maxIndex);
		}
		else //Look in the bottom half of the array
		{
			return binarySearchRecur(a, val, minIndex, midIndex - 1);
		}
	}
	public static void selectionSort(int[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			int smallestIndex = i;
			for(int j = 0; j < a.length; j++)
			{
				if(a[smallestIndex] < a[j]) //True if found a smaller value
				{
					smallestIndex = j;
				}
			}
			if(i != smallestIndex) //Need to swap
			{
				int temp = a[i];
				a[i] = a[smallestIndex];
				a[smallestIndex] = temp;
			}
		}
	}
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
		for(int i = 0; i < left.length; i++) //Populate left
		{
			left[i] = a[i];
		}
		for(int i = mid; i < size; i++) //Populate right
		{
			right[i - size] = a[i];
		}
		mergeSort(left);
		mergeSort(right);
		//TODO merge
	}
}
