
public class AdjMatrixTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjMatrix m = new AdjMatrix(7);
		m.addEdge(0, 1, 1);
		m.addEdge(0, 3, 1);
		m.addEdge(1, 3, 1);
		m.addEdge(2, 0, 1);
		m.addEdge(2, 4, 1);
		m.addEdge(2, 5, 1);
		m.addEdge(3, 2, 1);
		m.addEdge(3, 4, 1);
		m.addEdge(4, 5, 1);
		m.addEdge(4, 6, 1);
		m.printAdjMatrix();
		System.out.println("DFS");
		m.printDFS();
		System.out.print("BFS");
		m.printBFS();
	}

}
