package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

class Graph {
	
	public ArrayList<ArrayList<Integer>> graph;
	
	public Graph(int v) {
		graph = new ArrayList<>();
		
		for(int i=0; i<v; i++)  {
			graph.add(new ArrayList<>());
		}
	}
	
	public void addEdges(int source, int destination) {
		graph.get(source).add(destination);
		graph.get(destination).add(source);
	}
	
		public static void main(String args[]) {
			Scanner sc = new Scanner(System.in);
			
			Graph g = new Graph(6);
			
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
			g.addEdges(0, 2);
			g.addEdges(1, 2);
			g.addEdges(2, 0);
			g.addEdges(2, 3);
			g.addEdges(3, 3);
	        
			System.out.println("our built graph  is: ");
			for(int i=0; i < 6;i++) {
				System.out.print("Node "+i+" :");
				for(int j : g.graph.get(i)) 
					System.out.print(j+" ");
				System.out.println();
			}
			sc.close();
		}
}