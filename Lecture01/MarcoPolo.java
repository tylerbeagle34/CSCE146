//import java.util.Scanner;
//import java.util.Random;
import java.util.*;
public class MarcoPolo {
	
	public static final int BOARD_SIZE = 10; //Constant
	public static final int COLD_DISTANCE = (BOARD_SIZE/2) * (BOARD_SIZE/2);
	public static final int WARM_DISTANCE = (BOARD_SIZE/4) * (BOARD_SIZE/4);
	enum Space {Empty, Player, Walked_Path, Goal};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int pX = 0;
		int pY = 0;
		
		Random r = new Random();
		
		int gX = r.nextInt(BOARD_SIZE);
		int gY = r.nextInt(BOARD_SIZE);
		//int gY = r.nextInt(10); //WRONG! Magic Number
		
		Space[][] board = new Space[BOARD_SIZE][BOARD_SIZE];
		for(int y = 0; y < board.length; y++)
		{
			for(int x = 0; x < board[y].length; x++)
			{
				board[x][y] = Space.Empty;
			}
		}
		board[pX][pY] = Space.Player;
		board[gX][gY] = Space.Goal;
		System.out.println("Marco Polo Game");
		boolean gameOver = false;
		while(!gameOver) //Game Loop
		{
			//Draw the board
			for(int y = 0; y < board.length; y++)
			{
				for(int x = 0; x < board[y].length; x++)
				{
					switch(board[x][y])
					{
					case Empty:
						System.out.print("_");
						break;
					case Player:
						System.out.print("X");
						break;
					case Walked_Path:
						System.out.print("#");
						break;
					case Goal:
						System.out.print("_");
						break;
					default:
						System.out.print("?");
						break;
					}
				}
				System.out.println();
			}
			//Distance from the goal
			int distance = (pX - gX) * (pX - gX) + (pY - gY) * (pY - gY);
			if(distance > COLD_DISTANCE)
			{
				System.out.println("You are cold!");
			}
			else if(distance > WARM_DISTANCE)
			{
				System.out.println("You are warm!");
			}
			else
			{
				System.out.println("You are hot!");
			}
		}
	}

}
