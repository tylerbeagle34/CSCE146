/*
 * Written by Warren Beagle
 * Homework08: Jeep Heap
 * Front End
 */
import java.util.*;
public class JeepHeapTester {
	//Static variables
	public static final int TYPES = 7;
	public static final int MIN_WEIGHT = 4033;
	public static final int MIN_HORSEPOWER = 101;
	public static final int WEIGHT_DIFFERENCE = 1166;
	public static final int HORSEPOWER_DIFFERENCE = 150;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JeepHeap<Jeep> jeeps = new JeepHeap<Jeep>(); //Creates a new instance of the jeep hep
		Random r = new Random(); //Randoms
		//Add 15 jeeps to the heap
		System.out.println("Adding 15 Jeeps to the Jeep Heap");
		for(int i = 0; i < jeeps.INSERT_INDEX; i++)
		{
			Jeep newJeep = new Jeep();
			int choice = r.nextInt(TYPES);
			switch(choice)
			{
			case 0:
				newJeep.setName("Grand Cherokee"); //Sets the name of the jeep
				break;
			case 1:
				newJeep.setName("Cherokee");
				break;
			case 2:
				newJeep.setName("Wrangler");
				break;
			case 3:
				newJeep.setName("Renegade");
				break;
			case 4:
				newJeep.setName("Commander");
				break;
			case 5:
				newJeep.setName("CJ");
				break;
			case 6:
				newJeep.setName("Forward Control");
				break;
			default:
				break;
			}
			newJeep.setWeight(r.nextInt(MIN_WEIGHT) + WEIGHT_DIFFERENCE); //Sets the weight of the jeep
			newJeep.setHorsepower(r.nextInt(MIN_HORSEPOWER) + HORSEPOWER_DIFFERENCE); //Sets the horsepower of the jeep
			jeeps.addJeep(newJeep); //Adds the jeep
		}
		jeeps.jeepRollCall(); //Prints out the jeeps
		//Removes 5 jeeps from the heap
		for(int i = 0; i < jeeps.REMOVE_INDEX; i++)
		{
			System.out.println("\nRemoving " + jeeps.peekJeep() + " from the Jeep Heap");
			jeeps.removeJeep();
			jeeps.jeepRollCall();
		}
		jeeps.jeepHeapSort(); //Performs a heap sort on the jeep heap
	}
}
