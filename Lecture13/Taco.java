
public class Taco implements Comparable<Taco>{
	private double price;
	public Taco(double aPrice)
	{
		this.setPrice(aPrice);
	}
	public double getPrice()
	{
		return this.price;
	}
	public void setPrice(double aPrice)
	{
		if(aPrice >= 0.0)
		{
			this.price = aPrice;
		}
	}
	public int compareTo(Taco aTaco)
	{
		//return (int) (price - aTaco.getPrice());
		if(price < aTaco.getPrice())
		{
			return -1;
		}
		else if(price > aTaco.getPrice())
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}
	public String toString()
	{
		return "$" + this.price;
	}
}
