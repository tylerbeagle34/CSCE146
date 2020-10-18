/*
 * Written by Warren Beagle
 * Homework08: Jeep Heap
 */
public class Jeep implements Comparable<Jeep> {
	//Instance variables
	private String name;
	private int weight;
	private int horsepower;
	//Constructors
	public Jeep() //Default
	{
		this.name = "no name yet";
		this.weight = 0;
		this.horsepower = 0;
	}
	public Jeep(String aName, int aWeight, int aHorsepower) //Parameterized
	{
		this.setName(aName);
		this.setWeight(aWeight);
		this.setHorsepower(aHorsepower);
	}
	//Accessors
	public String getName()
	{
		return this.name;
	}
	public double getWeight()
	{
		return this.weight;
	}
	public double getHorsepower()
	{
		return this.horsepower;
	}
	//Mutators
	public void setName(String aName)
	{
		if(aName != null) //Checks for a valid name
		{
			this.name = aName;
		}
	}
	public void setWeight(int aWeight)
	{
		if(aWeight > 0.0) //Checks for a valid weight
		{
			this.weight = aWeight;
		}
	}
	public void setHorsepower(int aHorsepower)
	{
		if(aHorsepower > 0.0) //Checks for a valid horsepower
		{
			this.horsepower = aHorsepower;
		}
	}
	//toString method
	public String toString()
	{
		return "Name: " + this.name + " Weight: " + this.weight + "lbs. Horsepower: " + this.horsepower + "hp";
	}
	//compareTo method from Comparable
	public int compareTo(Jeep aJeep)
	{
		if(this.horsepower < aJeep.getHorsepower())
		{
			return -1;
		}
		else if(this.horsepower > aJeep.getHorsepower())
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}
}
