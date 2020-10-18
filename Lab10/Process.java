/*
 * Written by Warren Beagle
 * Lab10: Process Heap
 */
public class Process implements Comparable<Process>{
	//Instance variables
	private int priority;
	private double time;
	private String name;
	//Constructors
	public Process() //Default
	{
		this.priority = 0;
		this.time = 0.0;
		this.name = "no name yet";
	}
	public Process(String aName, int aPriority, double aTime) //Parameterized
	{
		this.setName(aName);
		this.setPriority(aPriority);
		this.setTime(aTime);
	}
	//Accessors
	public int getPriority()
	{
		return this.priority;
	}
	public double getTime()
	{
		return this.time;
	}
	public String getName()
	{
		return this.name;
	}
	//Mutators
	public void setPriority(int aPriority)
	{
		if(aPriority >= 0) //Checks for valid priority values
		{
			this.priority = aPriority;
		}
		else
		{
			this.priority = 0;
		}
	}
	public void setTime(double aTime)
	{
		if(aTime >= 0.0) //Checks for valid time values
		{
			this.time = aTime;
		}
		else
		{
			this.time = 0.0;
		}
	}
	public void setName(String aName)
	{
		if(aName != null) //Checks for valid names 
		{
			this.name = aName;
		}
	}
	//Other methods
	public String toString() //to String method
	{
		return this.name + " " + this.priority + " " + this.time;
	}
	public int compareTo(Process aProcess) //Compare the priorities
	{
		if(this.priority < aProcess.getPriority())
		{
			return -1;
		}
		else if(this.priority > aProcess.getPriority())
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}
}
