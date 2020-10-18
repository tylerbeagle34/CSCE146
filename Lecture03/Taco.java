
public class Taco {
	private String name;
	private String location;
	private double price;
	
	public Taco()
	{
		this.name = this.location = "none";		
		this.price = 0.0;
	}
	public Taco(String aName, String aLocation, double aPrice)
	{
		this.setName(aName);
		this.setLocation(aLocation);
		this.setPrice(aPrice);
	}
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getLocation() 
	{
		return location;
	}
	public void setLocation(String location) 
	{
		this.location = location;
	}
	public double getPrice() 
	{
		return price;
	}
	public void setPrice(double price) 
	{
		if(price >= 0.0)
		{
			this.price = price;
		}
	}
	
	public String toString()
	{
		return "Name: " + this.name + "\nLocation: " + this.location + "\nPrice: " + this.price;
	}
	public boolean equals(Taco aTaco)
	{
		return aTaco != null && this.name.equals(aTaco.getName()) && this.location.equals(aTaco.getLocation()) && this.price == aTaco.getPrice();
	}
	
}
