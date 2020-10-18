/*
 * Written by Warren Beagle
 * Lab10: Fruit Tree
 */
public class Fruit implements Comparable<Fruit>{
	//Instance variables 
	private String type;
	private double weight;
	//Constructors
	public Fruit() //Default
	{
		this.type = "no type yet";
		this.weight = 0.0;
	}
	public Fruit(String aType, double aWeight) //Parameterized 
	{
		this.setType(aType);
		this.setWeight(aWeight);
	}
	//Accessors
	public String getType()
	{
		return this.type;
	}
	public double getWeight()
	{
		return this.weight;
	}
	//Mutators
	public void setType(String aType)
	{
		if(aType != null) //Checks for valid values 
		{
			this.type = aType;
		}
	}
	public void setWeight(double aWeight)
	{
		if(aWeight > 0.0) //Checks for valid values 
		{
			this.weight = aWeight;
		}
	}
	//Other methods 
	public String toString() //toString method
	{
		return this.type + " " + this.weight;
	}
	public boolean equals(Fruit aFruit) //equals method
	{
		return aFruit != null && this.type.equalsIgnoreCase(aFruit.getType()) && this.weight == aFruit.getWeight();
	}
	public int compareTo(Fruit aFruit) //Compare to method to compare the weights of the fruits
	{
		if(this.weight < aFruit.getWeight())
		{
			return -1;
		}
		else if(this.weight > aFruit.getWeight())
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}
}
