
public class Person {
	//Attributes
	private String name;
	//Constructors
	public Person() //Default
	{
		this.name = "no name yet";
	}
	public Person(String aName) //Parameterized
	{
		//TODO call the mutator
		this.setName(aName);
	}
	//Accessors 
	public String getName()
	{
		return this.name;
	}
	//Mutators
	public void setName(String aName)
	{
		this.name = aName;
	}
	//Other methods
	public String toString()
	{
		return "Name: " + this.name;
	}
	public boolean equals(Person aPerson)
	{
		return aPerson != null && this.name.equalsIgnoreCase(aPerson.getName());
	}
}
