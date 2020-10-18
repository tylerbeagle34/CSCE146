
public class Taco {
	private String name;
	private String location;
	private double price;
	private int rating; //Rating has to be between 0 and 4
	public Taco()
	{
		name = location = "none";
		price = 0.0;
		rating = 0;
	}
	public Taco(String aName, String aLocation, double aPrice, int aRating)
	{
		//TODO call mutators
		this.setName(aName);
		this.setLocation(aLocation);
		this.setPrice(aPrice);
		this.setRating(aRating);
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
		if(price >= 0)
		{
			this.price = price;
		}
	}
	public int getRating() 
	{
		return rating;
	}
	public void setRating(int rating) 
	{
		if(rating >= 0 && rating <= 4)
		{
			this.rating = rating;
		}
	}
	public String toString()
	{
		return "Name:  " + name + "\nLocation: " + location + "\nPrice: " + price + "\nRating: " + rating;
	}
	public boolean equals(Taco aTaco)
	{
		return aTaco != null && name.equals(aTaco.getName()) && location.equals(aTaco.getLocation()) && price == aTaco.getPrice() && rating == aTaco.getRating();
	}
}
