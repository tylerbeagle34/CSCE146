
public class Vertex {
	public double dist = Double.MAX_VALUE;
	public Vertex prev = null;
	public int x; 
	public int y;
	public Vertex(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public int compareTo(Vertex v)
	{
		if(this.dist < v.dist)
		{
			return -1;
		}
		else if(this.dist > v.dist)
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
		return x + " " + y + " " + dist;
	}
}
