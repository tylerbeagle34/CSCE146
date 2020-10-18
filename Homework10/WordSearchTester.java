/*
 * Written by Warren Beagle
 * Homework10: Unlicensed Word Finding Game
 */
public class WordSearchTester {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch wordSearch = new WordSearch(); //Creates a new instance of the word search class
		wordSearch.readDictionaryFile("./dict.txt"); //Read the provided dictionary file
		//wordSearch.print();
		char[][] wordSearchBoard = {{'R','A','H','J','M'}, {'Y','U','W','W','K'}, {'R','X','N','F','M'}, {'Q','G','E','E','B'}, {'E','O','A','P','E'}}; //Populate the matrix with the given letters 
		//Print out the matrix of letters 
		for(int i = 0; i < wordSearchBoard.length; i++)
		{
			for(int j = 0; j < wordSearchBoard[0].length; j++)
			{
				System.out.print(wordSearchBoard[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		wordSearch.findWords(wordSearchBoard); //Performs the word search
	}
}
