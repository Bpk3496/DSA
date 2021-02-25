package Graphs;

import java.util.ArrayList;

public class CycleUndirectedGraph {

	public static ArrayList<ArrayList<Integer>> graph;
	
	public CycleUndirectedGraph(int vertices) {
		graph = new ArrayList<>();
		for(int i =0; i < vertices; i++) {
			graph.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdges(int v, int s) {
		graph.get(v).add(s);
		graph.get(s).add(v);
	}
	
	public void printGraph() {
		for(int i=0;i<graph.size();i++) {
			for(int j =0;j< graph.get(i).size(); j++)
				System.out.print(graph.get(i).get(j)+" ");
			System.out.println();
		}
	}
	public boolean isCyclic(int child, int parent, boolean[] visited) {
		System.out.println("visited array curr length is "+ visited.length+" array  index is   "+ child +" with value "+visited[child] );
		visited[child] = true;
		System.out.println(visited[child]);
			for(int adjNodes : graph.get(child)) {
				if(!visited[adjNodes]) {
					if(isCyclic(adjNodes,child,visited))
						return true;	
				}
				else if(adjNodes != parent) {
					return true;
				}
			}
		
		return false;
	}
	
	public static void main(String[] args) {
		CycleUndirectedGraph g = new CycleUndirectedGraph(5);
		
		g.addEdges(0, 1);
		g.addEdges(0, 3);
		g.addEdges(0, 4);
		g.addEdges(1, 2);
		g.addEdges(3, 4);
		g.addEdges(2, 4);

//		g.addEdges(1, 2); g.addEdges(2, 3);	g.addEdges(3, 4);
		
		boolean[] visited = new boolean[graph.size()];
		
		for(int i=0; i< visited.length;i++)
			visited[i] = false;
		boolean flag = g.isCyclic(1,-1, visited);
		
		if(flag)
			System.out.println("Given Graph is cyclic");
		else
			System.out.println("Given Graph is not cyclic");
		
		g.printGraph();
	}

}
