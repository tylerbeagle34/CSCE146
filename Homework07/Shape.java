/*
 * Written by Warren Beagle
 * Homework07: Shape Tree
 */
public class Shape implements Comparable<Shape> {
	//Instance variables 
	private String type;
	private double area;
	//Constructors 
	public Shape() //Default
	{
		this.type = "no type yet";
		this.area = 0.0;
	}
	public Shape(String aType, double anArea) //Parameterized 
	{
		this.setType(aType);
		this.setArea(anArea);
	}
	public String getType() //Accessor for the type 
	{
		return this.type;
	}
	public void setType(String aType) //Mutator for the type 
	{
		if(aType != null) //Checks for valid types 
		{
			this.type = aType;
		}
	}
	public double getArea() //Accessor for the area 
	{
		return this.area;
	}
	public void setArea(double anArea) //Mutator for the area 
	{
		if(anArea != 0.0) //Checks for valid area values 
		{
			this.area = anArea;
		}
	}
	//Compare to method 
	public int compareTo(Shape aShape)
	{
		if(area < aShape.getArea())
		{
			return -1;
		}
		else if(area > aShape.getArea())
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}
}
