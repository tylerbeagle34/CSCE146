import java.util.*;
public class Graph {
	private class Vertex
	{
		String name; //Should be unique 
		ArrayList<Edge> neighbors;
		public Vertex(String aName)
		{
			name = aName;
			neighbors = new ArrayList<Edge>();
		}
	}
	private class Edge
	{
		Vertex toVert;
		double weight;
		public Edge(Vertex aVert, double aWeight)
		{
			toVert = aVert;
			weight = aWeight;
		}
	}
	private Vertex origin;
	private ArrayList<Vertex> vertices;
	private ArrayList<Vertex> markedVerts;
	private Queue<Vertex> vQ;
	public Graph()
	{
		origin = null;
		vertices = new ArrayList<Vertex>();
		markedVerts = new ArrayList<Vertex>();
		vQ = new LinkedList<Vertex>();
	}
	public void addVertex(String aName)
	{
		//Can't have duplicate names
		for(Vertex v : vertices)
		{
			if(v.name.equals(aName))
			{
				return;
			}
		}
		//Create vertex
		Vertex v = new Vertex(aName);
		vertices.add(v);
		if(origin == null)
		{
			origin = v;
		}
	}
	public void addEdge(String fromVert, String toVert, double aWeight)
	{
		Vertex v1 = findVertex(fromVert);
		Vertex v2 = findVertex(toVert);
		if(v1 == null || v2 == null) //Either one or both were not found
		{
			return;
		}
		v1.neighbors.add(new Edge(v2, aWeight));
	}
	private Vertex findVertex(String aName)
	{
		for(Vertex v : vertices)
		{
			if(v.name.equals(aName))
			{
				return v;
			}
		}
		return null;
	}
	public void printDFS()
	{
		markedVerts.clear(); //Make sure marked verts are empty
		printDFS(origin);
	}
	private void printDFS(Vertex vert)
	{
		if(markedVerts.contains(vert)) //Already visited so leave
		{
			return;
		}
		System.out.println(vert.name);
		markedVerts.add(vert);
		for(Edge e : vert.neighbors)
		{
			printDFS(e.toVert);
		}
	}
	public void printBFS()
	{
		markedVerts.clear();
		vQ.clear();
		System.out.println(origin.name);
		vQ.add(origin);
		printBFS(origin);
		
	}
	private void printBFS(Vertex vert)
	{
		while(!vQ.isEmpty())
		{
			Vertex v = vQ.remove();
			markedVerts.add(v);
			for(Edge e : v.neighbors)
			{
				if(!vQ.contains(e.toVert) && !markedVerts.contains(e.toVert))
				{
					System.out.println(e.toVert.name);
					vQ.add(e.toVert);
				}
			}
		}
	}
}	
