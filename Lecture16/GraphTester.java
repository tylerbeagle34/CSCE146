
public class GraphTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		System.out.println("Adding vertices");
		for(int i = 1; i <= 7; i++)
		{
			g.addVertex("v" + i);
		}
		System.out.println("Adding edges");
		g.addEdge("v1", "v2", 1);
		g.addEdge("v1", "v6", 1);
		g.addEdge("v2", "v3", 1);
		g.addEdge("v3", "v4", 1);
		g.addEdge("v3", "v5", 1);
		g.addEdge("v6", "v7", 1);
		g.addEdge("v7", "v1", 1);
		System.out.println("DFS");
		g.printDFS();
		System.out.println("BFS");
		g.printBFS();
	}

}
