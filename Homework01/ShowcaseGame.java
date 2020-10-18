/*
 * Written by Warren Beagle
 * Homework 01: Showcase Showdown!
 */
import java.util.Scanner;
public class ShowcaseGame {

	public static final int DIFFERENCE = 2000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Showcase showcase = new Showcase();
		Scanner keyboard = new Scanner(System.in);
		//Gameplay
		boolean quit = false;
		while(quit == false)
		{
			quit = true; 
			System.out.println("Welcome to the Showcase Showdown \nYour prizes are:");
			showcase.readPrizeFile("./prizeList.txt"); //Read the prize file
			//showcase.print();
			System.out.println("You must guess the total cost of all without going over \nEnter your guess");
			int guess = keyboard.nextInt(); //Guess the total
			keyboard.nextLine();
			System.out.println("You guessed " + guess + " the actual price is " + showcase.getSum());
			//Determine the difference and if your win
			if(guess > showcase.getSum())
			{
				System.out.println("I'm sorry but that was over... You get nothing");
			}
			else if(guess - showcase.getSum() <= DIFFERENCE)
			{
				System.out.println("Your guess was under!  You win!");
			}
			else
			{
				System.out.println("I'm sorry but that guess was bad.  You lose for being bad.");
			}
			//Ask to play again
			System.out.println("Would you like to play again? Yes or No?");
			String choice = keyboard.nextLine();
			switch(choice)
			{
				case "yes":
					quit = false;
					break;
				case "no":
					System.out.println("Thanks for playing!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice. Thanks for playing");
					System.exit(0);
					break;
						
			}
		}
	}

}
