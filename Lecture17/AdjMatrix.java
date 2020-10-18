import java.util.*;
public class AdjMatrix {
	private double[][] adjMatrix;
	private static final int DEFAULT_VERT_SIZE = 10;
	private ArrayList<Integer> markedVerts;
	private Queue<Integer> vQ;
	public AdjMatrix()
	{
		init(DEFAULT_VERT_SIZE);
	}
	public AdjMatrix(int size)
	{
		init(size);
	}
	private void init(int size)
	{
		if(size <= 0)
		{
			return;
		}
		adjMatrix = new double[size][size];
		for(int i = 0; i < adjMatrix.length; i++)
		{
			for(int j = 0; j < adjMatrix[i].length; j++)
			{
				adjMatrix[i][j] = 0;
			}
		}
		markedVerts = new ArrayList<Integer>();
		vQ = new LinkedList<Integer>();
	}
	public void addEdge(int fromVert, int toVert, double weight)
	{
		if(fromVert < 0 || toVert < 0)
		{
			return;
		}
		adjMatrix[fromVert][toVert] = weight;
	}
	public void printAdjMatrix()
	{
		for(int i = 0; i < adjMatrix.length; i++)
		{
			for(int j = 0; j < adjMatrix[i].length; j++)
			{
				System.out.print(adjMatrix[i][j] + "|");
			}
			System.out.println();
		}
	}
	public void printDFS()
	{
		markedVerts.clear();
		printDFS(0);
	}
	private void printDFS(int index)
	{
		System.out.println(index);
		markedVerts.add(index);
		for(int i = 0; i < adjMatrix[index].length; i++)
		{
			if(adjMatrix[index][i] != 0 && !markedVerts.contains(i))
			{
				printDFS(i);
			}
		}
	}
	public void printBFS()
	{
		markedVerts.clear();
		vQ.clear();
		markedVerts.add(0);
		vQ.add(0);
		System.out.println(0);
		printBFS(0);
	}
	private void printBFS(int index)
	{
		while(!vQ.isEmpty())
		{
			int currI = vQ.remove();
			markedVerts.add(currI);
			for(int i = 0; i < adjMatrix[currI].length; i++)
			{
				if(!markedVerts.contains(i) && !vQ.contains(i) && adjMatrix[currI][i] != 0)
				{
					System.out.println(i);
					vQ.add(i);
				}
			}
		}
	}
}
