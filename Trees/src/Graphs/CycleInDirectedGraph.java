package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CycleInDirectedGraph {

	public List<List<Integer>>  graph;
	int vertices;
	
	public CycleInDirectedGraph(int vertices) {
		this.vertices = vertices;
		graph = new ArrayList<>();
		
		for(int i=0; i < vertices;i++) {
			graph.add(new ArrayList<>());
		}
	}
	
	public void addEdge(int source, int destination) {
		graph.get(source).add(destination);
	}
	
	public boolean isCyclicUtil(int currVertex, boolean[] visited, boolean[] recStackVistedList) {
		
		if(recStackVistedList[currVertex])
			return true;

		if(visited[currVertex])
			return false;
		
		visited[currVertex] = true;
		recStackVistedList[currVertex] = true; 

		List<Integer> children = graph.get(currVertex); 
		
        for (Integer c: children)  {
        	if(isCyclicUtil(c, visited, recStackVistedList))
				return true;
        }
		recStackVistedList[currVertex] = false;
		
		return  false;
	}

	public boolean isCyclic() {
		
		boolean visited[] = new boolean[graph.size()];
		boolean recStackVistedList[] = new boolean[graph.size()];
		
		for(int i=0;i< graph.size();i++) {
			if(isCyclicUtil(i,visited,recStackVistedList))
				return true;
		}
		return false;
		
	}
	
		public static void main(String[] args) {
		CycleInDirectedGraph graph = new CycleInDirectedGraph(4);

		graph.addEdge(0, 1); 
		graph.addEdge(0, 2); 
		graph.addEdge(1, 2); 
		/*graph.addEdge(2, 0); */ 
		graph.addEdge(2, 3); 
		 graph.addEdge(3, 3); 
        
	        if(graph.isCyclic()) 
	        	System.out.println("Graph is cyclic");
	        else 
	        	System.out.println("graph is not a cyclic");
	        }
} 

/*
import java.util.ArrayList; 
import java.util.LinkedList; 
import java.util.List; 

class CycleInDirectedGraph { 
	
	private final int V; 
	private final List<List<Integer>> adj; 

	public CycleInDirectedGraph(int V) { 
		this.V = V; 
		adj = new ArrayList<>(V); 
		
		for (int i = 0; i < V; i++) 
			adj.add(new LinkedList<>()); 
	} 
	private boolean isCyclicUtil(int i, boolean[] visited,  boolean[] recStack)  { 
		
		if (recStack[i]) 
			return true; 

		if (visited[i]) 
			return false; 
			
		visited[i] = true; 
		recStack[i] = true;
		
		List<Integer> children = adj.get(i); 
		
		for (Integer c: children) 
			if (isCyclicUtil(c, visited, recStack)) 
				return true; 
				
		recStack[i] = false; 

		return false; 
	} 

	private void addEdge(int source, int dest) { 
		adj.get(source).add(dest); 
	} 

	private boolean isCyclic() {  
		boolean[] visited = new boolean[V]; 
		boolean[] recStack = new boolean[V]; 
		 
		for (int i = 0; i < V; i++) 
			if (isCyclicUtil(i, visited, recStack)) 
				return true; 

		return false; 
	} 

	public static void main(String[] args) 
	{ 
		CycleInDirectedGraph graph = new CycleInDirectedGraph(4); 
		graph.addEdge(0, 1); 
		graph.addEdge(0, 2); 
		graph.addEdge(1, 2); 
		//graph.addEdge(2, 0); 
		graph.addEdge(2, 3); 
		//graph.addEdge(3, 3); 
		
		if(graph.isCyclic()) 
			System.out.println("Graph contains cycle"); 
		else
			System.out.println("Graph doesn't "
									+ "contain cycle"); 
	} 
} */