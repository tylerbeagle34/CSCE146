import java.util.*;
import java.io.*;
public class TacoManager {
	private GenLinkedList<Taco> tacos;
	public static final String DELIM = "\t";
	public static final int FIELD_AMT = 4;
	public TacoManager()
	{
		tacos = new GenLinkedList<Taco>();
	}
	public void addNewTaco(Taco aTaco)
	{
		tacos.insert(aTaco);
	}
	public void removeTaco(Taco aTaco)
	{
		tacos.resetCurrent(); //Points current to head
		while(tacos.moreToIterate())
		{
			if(tacos.getCurrent().equals(aTaco))
			{
				tacos.deleteCurrent();
				break;
			}
			tacos.moveCurrentForward();
		}	
	}
	public void printTacoList()
	{
		tacos.print();
	}
	public void writeToTacoFile(String fileName)
	{
		if(tacos == null || fileName == null)
		{
			return;
		}
		try
		{
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName));
			tacos.resetCurrent();
			while(tacos.moreToIterate())
			{
				Taco temp = tacos.getCurrent();
				fileWriter.println(temp.getName() + DELIM + temp.getLocation() + DELIM + temp.getPrice() + DELIM + temp.getRating());
				tacos.moveCurrentForward();
			}
			fileWriter.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void readTacoFile(String fileName)
	{
		if(fileName == null)
		{
			return;
		}
		//Assume we create a new list
		tacos = new GenLinkedList<Taco>();
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			while(fileScanner.hasNextLine())
			{
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if(splitLines.length != FIELD_AMT)
				{
					continue;
				}
				String name = splitLines[0];
				String location = splitLines[1];
				double price = Double.parseDouble(splitLines[2]);
				int rating = Integer.parseInt(splitLines[3]);
				Taco newTaco = new Taco(name, location, price, rating);
				tacos.insert(newTaco);
			}
			fileScanner.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
