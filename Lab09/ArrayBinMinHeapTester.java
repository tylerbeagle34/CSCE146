/*
 * Written by Warren Beagle
 * Lab09: Min Heap of Integers!
 * Front End
 */
public class ArrayBinMinHeapTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayBinMinHeap<Integer> heap = new ArrayBinMinHeap<Integer>(); //Creates a new instance of the heap
		//Insert values into the heap
		System.out.println("Int Min Heap Tester \nPopulating Heap with values");
		heap.insert(21);
		heap.insert(37);
		heap.insert(49);
		heap.insert(11);
		heap.insert(23);
		heap.insert(1);
		heap.insert(13);
		heap.insert(16);
		heap.insert(33);
		heap.insert(17);
		heap.print(); //Print the heap
		/*System.out.println("Testing heap sort");
		heap.heapSort();*/
		//Remove an element from the heap
		System.out.println("\nRemoving an element from the heap \nThe element removed is " + heap.peek() + " and the heap now is:");
		heap.remove();
		heap.print();
	}

}
