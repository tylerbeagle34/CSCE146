/*
 * Written by Warren Beagle
 * Homework10: Unlicensed Word Finding Game
 */
import java.io.*;
import java.util.*;
public class WordSearch {
	public static final int DICT_SIZE = 25144;
	private String[] words;
	//Constructors
	public WordSearch() //Default
	{
		words = new String[DICT_SIZE];
	}
	public WordSearch(int size) //Parameterized
	{
		if(size > 0)
		{
			words = new String[size];
		}
	}
	//Assuming that all null elements are at the end of the array
	public void addWord(String aWord)
	{
		for(int i = 0; i < words.length; i++)
		{
			if(words[i] == null) //Found the first empty element
			{
				words[i] = aWord; //Adds the word to that empty element of the array
				break;
			}
		}
	}
	//Reads the dictionary file and populates an array with all of the words in the dictionary
	public void readDictionaryFile(String fileName)
	{
		if(fileName == null) //Empty file name 
		{
			return;
		}
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			String fileLine;
			while(fileScanner.hasNextLine())
			{
				fileLine = fileScanner.nextLine();
				this.addWord(new String(fileLine)); //Adds the file line to the array of words
			}
			fileScanner.close(); //Closes teh file scanner 
		}
		//Exception
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//Print the words in the dictionary
	public void print()
	{
		for(int i = 0; i < words.length; i++)
		{
			System.out.println(words[i]); //Prints out every word for the different array index values 
		}
	}
	public boolean compareWords(String aWord)
	{
		//System.out.println(aWord);
		for (int i = 0; i < words.length;i++)
		{
			//Returns true if the word from the baord matches any of the words in the dictionary
			if (aWord.equalsIgnoreCase(words[i]))
			{
				return true;
			}
		}
		//Returns false otherwise
		return false;
	}
	//Method to find the words in the board
	public void findWords(char[][] board)
	{
		boolean[][] visitedChars = new boolean[board.length][board.length]; //Creats an array of characters that have been visited
		//Sets the starting position and creates an empty string for the word found
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board.length; j++)
			{
				System.out.println("Starting " + i + " " + j);
				String aWord = "";
				findingWords(board, visitedChars, i, j, aWord); //Calls the recursive method 
			}
		}
	}
	//Helper recursive method to find all of the words in the board
	private void findingWords(char[][] board, boolean[][] visitedChars, int rowPos, int columnPos, String aWord)
	{
		visitedChars[rowPos][columnPos] = true; //Marks the character as visited
	    aWord = aWord + board[rowPos][columnPos]; //Adds the character to the end of the string
	    //Compares to see if it is a word in the dictionary
	    if(compareWords(aWord) == true && aWord.length() > 1)
	    {
	        System.out.println("Found Word: " + aWord);
	    }
	    //Cannot have words greater than 6 letters in length
	    if(aWord.length() == 6)
	    {
	    		visitedChars[rowPos][columnPos] = false;
	        return;
	    }
	    //Goes to all of the surrounding letters and runs the method to find the different words
	    for(int rowIndex = rowPos - 1; rowIndex <= rowPos + 1 && rowIndex < board.length; rowIndex++)
	    {
	        for(int columnIndex = columnPos - 1; columnIndex <= columnPos + 1 && columnIndex < board.length; columnIndex++)
	        {
	            if(rowIndex >= 0 && columnIndex >= 0 && visitedChars[rowIndex][columnIndex] == false)
	            {
	                findingWords(board, visitedChars, rowIndex, columnIndex, aWord);
	            }
	        }
	    }
	    //Takes off the last letter of the string and sets the character to not visited
	    if(aWord.length() > 0) 
	    {
	        aWord = aWord.substring(0, aWord.length() - 1); //Removes the last letter from the string
	        visitedChars[rowPos][columnPos] = false; //Marks it as not visited
	    }
	}
}
