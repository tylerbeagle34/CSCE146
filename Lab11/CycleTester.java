/*
 * Written by Warren Beagle
 * Lab11: Finding Cycles
 */
public class CycleTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(); //Creates a new instance of the graph
		//Add the vertices 
		for(int i = 1; i <= 7; i++)
		{
			g.addVertex(i);
		}
		//Add the edges between the vertices 
		g.addEdge(1, 5, 1);
		g.addEdge(2, 1, 1);
		g.addEdge(3, 1, 1);
		g.addEdge(4, 2, 1);
		g.addEdge(5, 2, 1);
		g.addEdge(5, 3, 1);
		g.addEdge(5, 7, 1);
		g.addEdge(6, 3, 1);
		g.addEdge(7, 4, 1);
		g.addEdge(7, 6, 1);
		System.out.println("The cycles in this graph are: ");
		g.cycle(); //Prints the cycles 
	}

}
