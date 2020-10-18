/*
 * Written by Warren Beagle
 * Lab10: Fruit Tree
 */
import java.io.*;
import java.util.*;
public class FruitDatabase {
	LinkedBSTree<Fruit> fruitTree = new LinkedBSTree<Fruit>(); //New instance of the fruit tree 
	public static final String DELIM = "\t"; //Delmeter = tab
	public static final int FIELD_AMT = 2; //3 fields on each line 
	//Method to read the file 
	public void readFruitFile(String fileName)
	{
		if(fileName == null) //Empty file name 
		{
			return;
		}
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			while(fileScanner.hasNextLine())
			{
				//New instances of fruits 
				Fruit fruit = new Fruit();
				//Gets the file line and splits the lines 
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				//Populate the tree with fruits 
				if(splitLines.length == FIELD_AMT)
				{
					fruit.setType(splitLines[0]);
					fruit.setWeight(Double.parseDouble(splitLines[1]));
					fruitTree.insert(fruit);
				}
			}
			fileScanner.close();
		}
		//Exception
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
