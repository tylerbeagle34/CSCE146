/*
 * Written by Warren Beagle
 * Homework04: Reverse Polish Calculator!
 */
import java.util.Scanner;
public class ReversePolishCalc {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager rpcCalc = new Manager(); //Creates an instance of the manager
		Scanner keyboard = new Scanner(System.in); //Make use of the keyboard 
		System.out.println("Welcome to the reverse Polish Calculator! \nEnter the name of the file");
		String input = keyboard.nextLine(); //Gets the next line
		rpcCalc.readFile("./" + input); //Reads the input file and performs calculations
	}

}
