/*
 * Lab07: Linear Search Vs Binary Search
 * Written by Warren Beagle
 */
import java.util.Random;
public class LSvBS {
	//Instance variables
	public static int linearCount; 
	public static int binaryCount;
	public static final int ARRAY_SIZE = 1000; //Sets the array size
	public static final int TRIALS = 20;
	public static final int MIN = 0; //Min index
	public static final int MAX = 999; //Max index
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Welcome to the search tester.  We are going to see which algorithm performs the best out of 20 tests");
		//Counts for the average
		int totalLinearCount = 0;
		int totalBinaryCount = 0;
		int[] a = new int[ARRAY_SIZE]; //Instantiates a new array
		Random r = new Random(ARRAY_SIZE); //Gets a random value between 0-999
		//Run the check 20 times
		for(int i = 0; i < TRIALS; i++)
		{
			int val = r.nextInt(ARRAY_SIZE); //The value trying to find
			//Sets the total run count to 0
			linearCount = 0;
			binaryCount = 0;
			//Populates the array with random values between 0-999
			for(int j = 0; j < a.length; j++)
			{
				a[j] = r.nextInt(ARRAY_SIZE);			
			}
			bubbleSort(a); //Sorts the array
			//Print the array (NOT NECESSARY)
			/*for(int k = 0; k < a.length; k++)
			{
				System.out.println(a[k]);
			}*/
			//Print out the results and perform the different searches 
			System.out.println("Searching using linear search");
			System.out.println(linearSearchIter(a, val));
			totalLinearCount += linearCount; //Add to the total linear count for the average at the end 
			System.out.println("Searching using binary search");
			System.out.println(binarySearchRecur(a, val, MIN, MAX));
			totalBinaryCount += binaryCount; //Add to the total binary count for the average at the end
			System.out.println("Linear Checks: " + linearCount);
			System.out.println("Binary Checks: " + binaryCount);
			System.out.println();
		}
		//Print out the averages
		System.out.println("The average number of checks for 20 were: ");
		System.out.println("Linear Search: " + totalLinearCount / TRIALS);
		System.out.println("Binary Search: " + totalBinaryCount / TRIALS);
	}
	//Iterative Linear Search
	public static String linearSearchIter(int[] a, int val)
	{
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] == val) //Value is found 
			{
				return "Found!"; //Returns found
			}
			linearCount++; //Adds to the linear count
		}
		return "Not Found!"; //Return not found
	}
	//Recursive Linear Search (NOT NECESSARY)
	/*public static String linearSearchRecur(int[] a, int val, int currIndex)
	{
		linearCount++;
		if(a[currIndex] == val)
		{
			return "Found!";
		}
		currIndex++;
		if(currIndex >= a.length)
		{
			return "Not Found!";
		}
		else
		{
			return linearSearchRecur(a, val, currIndex);
		}
	}*/
	//Recursive binary search
	public static String binarySearchRecur(int[] a, int val, int minIndex, int maxIndex)
	{
		if(minIndex > maxIndex) //The value was not found
		{
			return "Not Found!"; //Return not found
		}
		binaryCount++;
		int midIndex = (maxIndex + minIndex) / 2;
		if(a[midIndex] == val) //Found the value
		{
			return "Found!"; //Return found
		}
		if(val > a[midIndex]) //Look in the top half of the array
		{
			return binarySearchRecur(a, val, midIndex + 1, maxIndex); //Performs the recursive search for the new values 
		}
		else //Look in the bottom half of the array
		{
			return binarySearchRecur(a, val, minIndex, midIndex - 1); //Performs the recursive search for the new values 
		}
	}
	//Selection Sort (NOT NECESSARY)
	/*public static void selectionSort(int[] a)
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
			}
			if(smallestIndex != i) //Need to swap
			{
				int temp = a[i];
				a[i] = a[smallestIndex];
				a[smallestIndex] = temp;
			}
		}
	}*/
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
}
