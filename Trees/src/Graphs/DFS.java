package Graphs;

import java.util.Stack;

public class DFS {

	public static Graph g = new Graph(6);
	
	public static void dfs(int start, int size) {
		Stack<Integer> s = new Stack<>();
		s.add(start);
		
		boolean visited[] = new boolean[size];
		visited[start] = true;
		
		while(!s.isEmpty()) {
			int temp = s.pop();
			System.out.println(temp+" ");
			
			for(int i=0;i< g.graph.get(temp).size(); i++) {
				int traversedNode = g.graph.get(temp).get(i);
				if(visited[traversedNode] != true) {
					s.push(traversedNode);
					visited[traversedNode] = true;
				}
			}
			
			System.out.println("traversed the list");
		}
		
	}
	public static void main(String[] args) {
		
		g.addEdges(0, 1);
		g.addEdges(0, 2);
		g.addEdges(1, 2);
		g.addEdges(2, 0);
		g.addEdges(2, 3);
		g.addEdges(3, 3);
        
		g.addEdges(0, 1); 
		g.addEdges(0, 2); 
		g.addEdges(1, 2); 
		g.addEdges(2, 0); 
		g.addEdges(2, 3); 
		g.addEdges(3, 3); 
		
		dfs(2,6);
	}

}
