/*
 * Written by Warren Beagle
 * Homework07: Shape Tree
 */
import java.io.*;
import java.util.*;
public class ShapeDatabase {
	LinkedBSTree shapeTree = new LinkedBSTree(); //New instance of the shape tree 
	public static final String DELIM = "\t"; //Delmeter = tab
	public static final int FIELD_AMT = 3; //3 fields on each line 
	//Method to read the file 
	public void readShapeDBFile(String fileName)
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
				//New instances of shapes 
				Rectangle rectangle = new Rectangle();
				RightTriangle rightTriangle = new RightTriangle();
				Circle circle = new Circle();
				//Gets the file line and splits the lines 
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				//Test whether it is a circle, rectangle, or right triangle 
				if(splitLines.length <= FIELD_AMT)
				{
					if(splitLines[0].equalsIgnoreCase("circle"))
					{
						System.out.println(fileLine);
						circle.setRadius(Integer.parseInt(splitLines[1]));
						shapeTree.insert(circle);
					}
					else if(splitLines[0].equalsIgnoreCase("rectangle"))
					{
						System.out.println(fileLine);
						rectangle.setSide1(Integer.parseInt(splitLines[1]));
						rectangle.setSide2(Integer.parseInt(splitLines[2]));
						shapeTree.insert(rectangle);
					}
					else if(splitLines[0].equalsIgnoreCase("right triangle"))
					{
						System.out.println(fileLine);
						rightTriangle.setSide1(Integer.parseInt(splitLines[1]));
						rightTriangle.setSide2(Integer.parseInt(splitLines[2]));
						shapeTree.insert(rightTriangle);
					}
					else
					{
						System.out.println("Not properly formatted line. Yes you should check for these.  Not intentionally causing a kerfuffle");
					}
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
