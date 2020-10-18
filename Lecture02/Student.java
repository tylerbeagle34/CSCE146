
public class Student extends Person {
	private int id;
	public Student()
	{
		super(); //Call the person's default constructor
		this.id = 0;
	}
	public Student(String aName, int anId)
	{
		super(aName); //Call the person's parameterized constructor
		//TODO call mutator for id
		this.setId(anId);
	}
	//Accessors
	public int getId() 
	{
		return this.id;
	}
	//Mutators
	public void setId(int anId) 
	{
		if(anId >= 0)
		{
			this.id = anId;
		}
	}
	public String toString()
	{
		return super.toString() + "\nID: " + this.id;
	}
	public boolean equals(Student aStudent)
	{
		return aStudent != null && super.equals(aStudent) && this.id == aStudent.getId();
	}
}