/*
 * Written by Warren Beagle
 * Lab05: Process Queue Simulator
 */
public class Process {
	//Instance variables
	private String name;
	private double completionTime;
	//Constructors
	public Process() //Default
	{
		name = "no name yet";
		completionTime = 0.0;
	}
	public Process(String aName, double aCompletionTime) //Parameterized
	{
		this.setName(aName);
		this.setCompletionTime(aCompletionTime);
	}
	//Accessors
	public String getName()
	{
		return this.name;
	}
	public double getCompletionTime()
	{
		return this.completionTime;
	}
	//Mutators
	public void setName(String aName)
	{
		if(aName != null) //Checks for valid name values
		{
			this.name = aName;
		}
	}
	public void setCompletionTime(double aCompletionTime)
	{
		if(aCompletionTime >= 0.0) //Checks for valid completion time values > 0.0
		{
			this.completionTime = aCompletionTime;
		}
		else
		{
			this.completionTime = 0.0;
		}
	}
	//Other methods
	public String toString() //Returns a string
	{
		return "Name: " + this.name + " Completion Time: " + this.completionTime;
	}
}
