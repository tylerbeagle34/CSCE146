import java.io.*;
import java.util.Scanner;
public class TacoDatabase {
	private Taco[] tacos;
	public static final int DEFAULT_SIZE = 100;
	public static final String DELIM = "\t";
	public static final int FIELD_AMT = 3;
	public TacoDatabase()
	{
		tacos = new Taco[DEFAULT_SIZE];
	}
	public TacoDatabase(int size)
	{
		if(size > 0)
		{
			tacos = new Taco[size];
		}
	}
	public Taco[] getTacos()
	{
		return this.tacos;
	}
	//Assuming that all null elements are at the end of the array
	public void addTaco(Taco aTaco)
	{
		if(tacos[tacos.length - 1] != null) //Array is full
		{
			return;
		}
		for(int i = 0; i < tacos.length; i++)
		{
			if(tacos[i] == null) //Found the first empty element
			{
				tacos[i] = aTaco;
			}
		}
	}
	//Removing Taco by its name
	public void removeTaco(String aName)
	{
		int removeIndex = -1;
		for(int i = 0; i < tacos.length; i++)
		{
			if(tacos[i] == null)
			{
				break;
			}
			else if(tacos[i].getName().equals(aName))
			{
				removeIndex = i;
				break;
			}
		}
		if(removeIndex == -1) //We didn't find a taco with that name
		{
			System.out.println("No taco with that name");
		}
		else //Found a taco
		{
			for(int i = removeIndex; i < tacos.length - 1; i++) //Shift over
			{
				tacos[i] = tacos[i+1];
			}
			tacos[tacos.length - 1] = null;
		}
	}
	
	public void writeTacoDBFile(String fileName)
	{
		if(fileName == null)
		{
			return;
		}
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName));
			for(int i = 0; i < tacos.length; i++)
			{
				if(tacos[i] == null)
				{
					break;
				}
				fileWriter.println(tacos[i].getName() + DELIM + tacos[i].getLocation() + DELIM + tacos[i].getPrice());
			}
			fileWriter.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void readTacoDBFile(String fileName)
	{
		if(fileName == null)
		{
			return;
		}
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			//Create a new array
			//First pass count the elements in the file
			int tacoAmt = 0;
			while(fileScanner.hasNextLine())
			{
				tacoAmt++;
				fileScanner.nextLine();
			}
			if(tacoAmt == 0)
			{
				return;
			}
			tacos = new Taco[tacoAmt];
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
					this.addTaco(new Taco(splitLines[0], splitLines[1], Double.parseDouble(splitLines[2])));
				}
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
