package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static Graph g = new Graph(6);
	
	private static void bfs(int start, int size) {
		
		boolean visited[] = new boolean[size];
		Queue<Integer> q = new LinkedList<Integer>();
		visited[start] = true;
		q.add(start);
		
		while(! q.isEmpty()) {
			int temp = q.poll();
			
			System.out.println(temp+ " ");
			
			for(int i = 0; i < g.graph.get(temp).size() ; i++) {
				int nodeVisited = g.graph.get(temp).get(i);
				if( visited[nodeVisited] != true) {
					q.add(nodeVisited);
					visited[nodeVisited]  = true;
				}
			}
		}
	} 
	public static void main(String[] args) {
		
		g.addEdges(0, 1);
		g.addEdges(0, 2);
		g.addEdges(1, 2);
		g.addEdges(2, 0);
		g.addEdges(2, 3);
		g.addEdges(3, 3);
        
		bfs(0,6);
	}
}
