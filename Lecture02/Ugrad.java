
public class Ugrad extends Student{
	private int level;
	public Ugrad()
	{
		super();
		this.level = 1;
	}
	public Ugrad(String aName, int anId, int aLevel)
	{
		super(aName, anId);
		this.setLevel(aLevel);
	}
	public int getLevel() 
	{
		return level;
	}
	public void setLevel(int aLevel) 
	{
		if(aLevel >=1 && aLevel <= 4)
		{
			this.level = aLevel;
		}
	}
	public String toString()
	{
		return super.toString() + "\nLevel: " + this.level;
	}
	public boolean equals(Ugrad anUgrad)
	{
		return anUgrad != null && super.equals(anUgrad) && this.level == anUgrad.level;
	}
}
