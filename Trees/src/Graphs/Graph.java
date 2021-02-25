package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

class Graph {
	
	public ArrayList<ArrayList<Integer>> graph;
	
	
	public Graph(int v) {
		graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<v; i++)  {
			graph.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdges(int source, int destination) {
		graph.get(source).add(destination);
//		graph.get(destination).add(source);
	}
	
	public 	void printGraph(int vertices) {
		System.out.println("Graph  : ");
		
		for(int i=0; i < vertices;i++) {
			System.out.print(i+" :");
			for(int j : graph.get(i)) 
				System.out.print("->"+j);
			System.out.println();
		}
	}
		public static void main(String args[]) {
			Scanner sc = new Scanner(System.in);
			
			Graph g = new Graph(5);
			
//			System.out.println("enter number of vertices");
//			int v = sc.nextInt();
//			System.out.println("enter number of edges");
//			int e = sc.nextInt();
//			
//			
//			
//			System.out.println("enter the graphs edges source and destination");
			
//			for(int i =0; i < e;i++) {
//				int source = sc.nextInt();
//				int destination = sc.nextInt();
//				g.addEdges(source, destination);
//			}
			   g.addEdges(0, 1); 
			   g.addEdges(2, 1); 
			   g.addEdges(2, 3); 
			   g.addEdges(3, 4); 
			   g.addEdges(4, 0); 
			   g.addEdges(4, 2); 
		       
			g.printGraph(5);
		sc.close();
		}
}