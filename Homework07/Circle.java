/*
 * Written by Warren Beagle
 * Homework07: Shape Tree
 */
public class Circle extends Shape {
	//Instance variable
	private int radius;
	//Constructors
	public Circle() //Default
	{
		this.radius = 0;
	}
	public Circle(String aType, int aRadius) //Parameterized
	{
		this.setRadius(aRadius);
	}
	public int getRadius() //Accessor for radius
	{
		return this.radius;
	}
	public void setRadius(int aRadius) //Mutator for radius
	{
		if(aRadius != 0) //Check for valid radius
		{
			this.radius = aRadius;
		}
	}
	public double getArea() //Calculates the area
	{
		return Math.PI * this.radius * this.radius;
	}
	public String toString() //Method to override toString
	{
		return this.getType() + " Radius: " + this.radius + " Area: " + this.getArea();
	}
	public String getType() //Gets the type of the shape
	{
		return "Circle";
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
