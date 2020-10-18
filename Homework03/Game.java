/*
 * Written by Warren Beagle
 * Homework03: Rock, Paper, Scissors Double Round Robin Tournament
 */
import java.util.Random;
public class Game {

	public static final int PLAYER_SIZE = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenCircularLinkedList<Player> players = new GenCircularLinkedList<Player>(); //Creates the players
		Random r = new Random(); //Creates a random
		//Variables to be used throughout
		int choice1;
		int choice2;
		int name1;
		int name2;
		//Inserts the players into the linked list
		for(int i = 0; i < PLAYER_SIZE; i ++)
		{
			players.insert(new Player(i, 0, 0, 0));
		}
		//Rock Paper Scissors game
		System.out.println("Welcome to the Rock Paper Scissors Tournament! \nWe have 5 players. Let's begin! \n");
		for(int i = 0; i < PLAYER_SIZE; i ++)
		{
			Player player1 = players.getDataAtCurrent(); //Gets the data at the current and sets it to player1
			players.goToNext();
			for(int j = 0; j < PLAYER_SIZE - 1; j ++)
			{
				Player player2 = players.getDataAtCurrent(); //Gets the data at the current and sets it to player2
				players.goToNext();
				//Sets the names
				name1 = player1.getName(); 
				name2 = player2.getName();
				//Random choices
				choice1 = r.nextInt(3); 
				choice2 = r.nextInt(3);
				//Gameplay
				if(choice1 == 0)
				{
					System.out.println(name1 + " uses rock");
				}
				else if(choice1 == 1)
				{
					System.out.println(name1 + " uses paper");
				}
				else
				{
					System.out.println(name1 + " uses scissors");
				}
				if(choice2 == 0)
				{
					System.out.println(name2 + " uses rock");
				}
				else if(choice2 == 1)
				{
					System.out.println(name2 + " uses paper");
				}
				else
				{
					System.out.println(name2 + " uses scissors");
				}
				//Scoring
				if(choice1 == choice2)
				{
					System.out.println("Tie!");
					player1.addTie(); //Adds a tie
					player2.addTie();
				}
				if((choice1 == 0 && choice2 == 2) || (choice1 == 1 && choice2 == 0) || (choice1 == 2 && choice2 == 1))
				{
					System.out.println(name1 + " wins!");
					player1.addWin(); //Adds a win
					player2.addLoss();
				}
				else if((choice1 == 2 && choice2 == 0) || (choice1 == 0 && choice2 == 1) || (choice1 == 1 && choice2 == 2))
				{
					System.out.println(name2 + " wins!");
					player1.addLoss(); //Adds a loss
					player2.addWin();
				}
			}
			players.goToNext(); //Goes to the next player
		}
		System.out.println("\nThe tournament is over here are the results!");
		players.showList(); //Prints the score
	}
}
