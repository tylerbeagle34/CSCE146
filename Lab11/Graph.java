/*
 * Written by Warren Beagle
 * Lab11: Finding Cycles
 */
import java.util.*;
public class Graph {
	private class Vertex
	{
		int name; //Should be unique 
		ArrayList<Edge> neighbors;
		public Vertex(int aName)
		{
			name = aName;
			neighbors = new ArrayList<Edge>();
		}
	}
	private class Edge
	{
		Vertex toVertex;
		double weight;
		public Edge(Vertex aVertex, double aWeight)
		{
			toVertex = aVertex;
			weight = aWeight;
		}
	}
	private Vertex origin;
	private ArrayList<Vertex> vertices;
	private ArrayList<Vertex> markedVertices;
	private Queue<Vertex> vQ;
	public Graph()
	{
		origin = null;
		vertices = new ArrayList<Vertex>();
		markedVertices = new ArrayList<Vertex>();
		vQ = new LinkedList<Vertex>();
	}
	public void addVertex(int aName)
	{
		//Can't have duplicate names
		for(Vertex v : vertices)
		{
			if(v.name == aName)
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
	public void addEdge(int fromVertex, int toVertex, double aWeight)
	{
		Vertex v1 = findVertex(fromVertex);
		Vertex v2 = findVertex(toVertex);
		if(v1 == null || v2 == null) //Either one or both were not found
		{
			return;
		}
		v1.neighbors.add(new Edge(v2, aWeight));
	}
	private Vertex findVertex(int aName)
	{
		for(Vertex v : vertices)
		{
			if(v.name == aName)
			{
				return v;
			}
		}
		return null;
	}
	public void cycle()
	{
		for(int i = 0; i < vertices.size(); i++)
		{
			markedVertices.clear(); //Make sure marked verts are empty
			cycle(vertices.get(i), vertices.get(i));
		}
	}
	private void cycle(Vertex startIndex, Vertex vertex)
	{
		//Check for a cycle
		if(markedVertices.size() > 1 && startIndex == vertex)
		{
			for(int i = 0; i < markedVertices.size(); i++)
			{
				System.out.print(markedVertices.get(i).name + " ");
			}
			System.out.println(startIndex.name);
		}
		if(markedVertices.contains(vertex)) //Already visited so leave
		{
			return;
		}
		markedVertices.add(vertex); //Adds the vertex to visited 
		for(Edge e : vertex.neighbors)
		{
			cycle(startIndex, e.toVertex); //Calls the cycle
		}
		markedVertices.remove(vertex); //Removes the vertex
	}
}	