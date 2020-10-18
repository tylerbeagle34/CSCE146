/*
 * Written by Warren Beagle
 * Lab00: Mine Counter!
 */
import java.util.Scanner;
import java.util.Random;
public class MineCounter {

	public static final int BOARD_SIZE = 10;
	enum Space{Empty, Mine}; //Creates a type Space
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		
		//Create empty board with size 10
		Space[][] board = new Space[BOARD_SIZE][BOARD_SIZE];
		for(int y = 0; y < board.length; y++)
		{
			for(int x = 0; x < board.length; x++)
			{
				board[y][x] = Space.Empty;
			}
		}
		
		//Draw the board
		System.out.println("Creating empty board");
		for(int y = 0; y < board.length; y++)
		{
			for(int x = 0; x < board[y].length; x++)
			{
				switch(board[y][x])
				{
				case Empty:
					System.out.print("_");
					break;
				default:
					System.out.print("?");
					break;
				}
			}
			System.out.println();
		}
		
		//Add 10 mines in random positions
		int mines = (BOARD_SIZE * BOARD_SIZE)/10;
		while(mines > 0)
		{
			int mX = r.nextInt(BOARD_SIZE);
			int mY = r.nextInt(BOARD_SIZE);
		    if(board[mY][mX] == Space.Empty)
		    { 
		    		board[mY][mX] = Space.Mine;
		        mines--;
		    }
		}
		//Draw the board with mines
		System.out.println("\nPlacing Mines");
		for(int y = 0; y < board.length; y++)
		{
			for(int x = 0; x < board[y].length; x++)
			{
				switch(board[y][x])
				{
				case Empty:
					System.out.print("_");
					break;
				case Mine:
					System.out.print("*");
					break;
				default:
					System.out.print("?");
					break;
				}
			}
			System.out.println();
		}
		
		//Perform Mine Count
		System.out.println("\nPerforming mine count");
		int[][] mineCount = new int[BOARD_SIZE + 2][BOARD_SIZE + 2];
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
            		//Check the bounds of the board (0 and 9)
            		int yStart = i-1;
            		int xStart = j-1;
            		if(yStart < 0)
            		{
            			yStart = 0; //If less than 0, set to 0
            		}
            		if(xStart < 0)
            		{
            			xStart = 0;
            		}
            		int yFinal = i+1;
            		int xFinal = j+1;
            		if(yFinal > 9)
            		{
            			yFinal = 9; //If greater than 9, set to 9
            		}
            		if(xFinal > 9)
            		{
            			xFinal = 9;
            		}
                for (int y = yStart; y <= yFinal; y++)
                {
                		for (int x = xStart; x <= xFinal; x++)
                		{
                			if(board[y][x] == Space.Mine) 
                			{
                				mineCount[i][j]++;
                			}
                		}
				}
			}
		}
        //Draw the board with the mine count
        for(int y = 0; y < board.length; y++)
		{
			for(int x = 0; x < board[y].length; x++)
			{
				switch(board[y][x])
				{
				case Empty:
					System.out.print(mineCount[y][x]);
					break;
				case Mine:
					System.out.print("*");
					break;
				default:
					System.out.print("?");
					break;
				}
			}
			System.out.println();
		}
	}
}
