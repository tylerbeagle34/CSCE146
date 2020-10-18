import java.io.*; //IO Package
import java.util.Scanner;
public class UndergraduateRecordSystem {
	//Delim
	public static final String DELIM = "\t";
	public static void recordToFile(Ugrad[] uGrads, String fileName, boolean append)
	{
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName));
			//Header
			fileWriter.print("Num of Students" + DELIM + uGrads.length);
			//Body
			for(int i = 0; i < uGrads.length; i++)
			{
				fileWriter.println(uGrads[i].getName() + DELIM + uGrads[i].getId() + DELIM + uGrads[i].getLevel());
			}
			fileWriter.close(); //DON'T FORGET THIS!!!
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static Ugrad[] readFromFile(String fileName)
	{
		if(fileName == null)
		{
			return null;
		}
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName)); //File Scanner
			/*//Get the header
			String fileLine = fileScanner.nextLine(); //Reads the line 
			String[] splitLine = fileLine.split(DELIM); //Splits the line
			Ugrad[] retUgrad;
			//Check if it has the right number of elements
			if(splitLine.length == 2)
			{
				retUgrad = new Ugrad[Integer.parseInt(splitLine[1])];
			}
			else
			{
				System.out.println("The header is ill formed");
				return null;
			}*/
			int numUGrads = 0;
			while(fileScanner.hasNextLine())
			{
				fileScanner.nextLine();
				numUGrads++;
			}
			fileScanner = new Scanner(new File(fileName)); //Moves back to top
			Ugrad[] retUgrad = new Ugrad[numUGrads];
			String fileLine;
			String[] splitLine;
			//Body
			int uGradCount = 0;
			while(fileScanner.hasNextLine())
			{
				fileLine = fileScanner.nextLine();
				splitLine = fileLine.split(DELIM);
				if(splitLine.length == 3)
				{
					String name = splitLine[0];
					int id = Integer.parseInt(splitLine[1]);
					int level = Integer.parseInt(splitLine[2]);
					retUgrad[uGradCount] = new Ugrad(name, id, level);
					uGradCount++;
				}
			}
			fileScanner.close(); //DON'T FORGET THIS!
			return retUgrad;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		boolean quit = false;
		System.out.println("Welcome to the Undergraduate Record System");
		while(quit == false)
		{
			System.out.println("Enter 1 to create a new record\n" + "Enter 2 to read from a file\n" + "Enter 0 to quit");
		}
	}

}
