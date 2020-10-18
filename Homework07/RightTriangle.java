/*
 * Written by Warren Beagle
 * Homework07: Shape Tree
 */
public class RightTriangle extends Shape {
	//Instance variables
	private int side1;
	private int side2;
	//Constructors 
	public RightTriangle() //Defualt 
	{
		this.side1 = 0;
		this.side2 = 0;
	}
	public RightTriangle(String aType, int aSide1, int aSide2) //Parameterized
	{
		this.setSide1(aSide1);
		this.setSide2(aSide2);
	}
	public int getSide1() //Accessor for side 1 
	{
		return this.side1;
	}
	public void setSide1(int aSide1) //Mutator for side 1
	{
		if(aSide1 != 0) //Checks for valid side values 
		{
			this.side1 = aSide1;
		}
	}
	public int getSide2() //Accessor for side 2
	{
		return this.side2;
	}
	public void setSide2(int aSide2) //Mutator for side 2
	{
		if(aSide2 != 0) //Checks for valid side values 
		{
			this.side2 = aSide2;
		}
	}
	public double getArea() //Calculates the area
	{
		return 0.5 * this.side1 * this.side2;
	}
	public String toString() //Overrides the toString method
	{
		return this.getType() + " Side 1: " + this.side1 + " Side 2: " + this.side2 + " Area: " + this.getArea();
	}
	public String getType() //Gets the type of shape 
	{
		return "Right Triangle";
	}
	//Compare to method 
	public int compareTo(Shape aShape)
	{
		if(this.getArea() < aShape.getArea())
		{
			return -1;
		}
		else if(this.getArea() > aShape.getArea())
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}
}
