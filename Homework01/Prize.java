/*
 * Written by Warren Beagle
 * Homework 01: Showcase Showdown!
 */
public class Prize {
	//Instance variables
	private String name;
	private int prize;
	
	//Constructors
	public Prize() //Default
	{
		this.name = "no name yet";
		this.prize = 0;
	}
	public Prize(String aName, int aPrize) //Parameterized
	{
		this.setName(aName);
		this.setPrize(aPrize);
	}
	
	//Accessors
	public String getName()
	{
		return this.name;
	}
	public int getPrize()
	{
		return this.prize;
	}
	
	//Mutators
	public void setName(String aName)
	{
		if(aName != null) //Checks for valid name
		{
			this.name = aName;
		}
	}
	public void setPrize(int aPrize)
	{
		if(aPrize > 0) //Checks for valid prize
		{
			this.prize = aPrize;
		}
		
	}
	
	//Other methods
	public String toString()
	{
		return this.name + " " + this.prize;
	}
	public boolean equals(Prize aPrize)
	{
		return aPrize != null && this.name.equals(aPrize.getName()) && this.prize == aPrize.getPrize();
	}
}
