/*
 * Written by Warren Beagle
 * Homework 01: Showcase Showdown!
 */
import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class Showcase {
	//Instance variables
	private Prize[] showcase;
	private int sum; //Sum of all the prizes
	public static final int DEFAULT_SIZE = 5; //Picks 5 
	public static final String DELIM = "\t";
	public static final int FIELD_AMT = 2; //Columns
	Random r = new Random();
	//Constructors
	public Showcase() //Default
	{
		showcase = new Prize[DEFAULT_SIZE];
		sum = 0;
	}
	public Showcase(int size, int aSum) //Parameterized
	{
		if(size > 0)
		{
			showcase = new Prize[size];
		}
		this.setSum(aSum);
	}
	//Accessors
	public Prize[] getShowcase()
	{
		return this.showcase;
	}
	public int getSum()
	{
		return this.sum;
	}
	//Mutator
	public void setSum(int aSum)
	{
		if(aSum > 0)
		{
			this.sum = aSum;
		}
	}
	//Assuming that all null elements are at the end of the array
	public void addPrize(Prize aPrize)
	{
		/*if(showcase[showcase.length - 1] != null) //Array is full
		{
			return;
		}*/
		for(int i = 0; i < showcase.length; i++)
		{
			if(showcase[i] == null) //Found the first empty element
			{
				showcase[i] = aPrize;
				break;
			}
		}
	}
	public void readPrizeFile(String fileName)
	{
		if(fileName == null)
		{
			return;
		}
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName)); //File Scanner
			int numPrizes = 0;
			int numLines = 0;
			while(fileScanner.hasNextLine())
			{
				numPrizes++;
				fileScanner.nextLine();
			}
			if(numPrizes == 0)
			{
				fileScanner.close();
				return;
			}
			showcase = new Prize[numPrizes];
			fileScanner = new Scanner(new File(fileName)); //Reset the scanner to the top
			//Second pass read the elements
			String fileLine;
			String[] splitLines;
			while(fileScanner.hasNextLine())
			{
				fileLine = fileScanner.nextLine();
				splitLines = fileLine.split(DELIM);
				if(splitLines.length == FIELD_AMT)
				{
					numLines++;
					this.addPrize(new Prize(splitLines[0], Integer.parseInt(splitLines[1])));
				}
			}
			for(int i = 0; i < DEFAULT_SIZE; i++)
			{
				int rand = r.nextInt(numLines);
				System.out.println(showcase[rand].getName());
				sum += showcase[rand].getPrize();
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
