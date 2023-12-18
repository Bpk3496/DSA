import java.io.*;
import java.util.*;

class Bfs {
	private int vertex;
	private LinkedList<Integer> adjList[];

	Bfs(int v) {
		this.vertex = v;
		adjList = new LinkedList[v];
		for(int i=0;i<v;i++){
			adjList[i] = new LinkedList<>();
		}
	}
    

	void addEdge(int u, int v) {
		adjList[u].add(v);
	}

	private void bfs(int startVertex) {
		boolean[] visited = new boolean[vertex];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		// for(int i=0; i<vertex; i++) {
		// if(visited[i] == false) {
		// for the disconnected components
		// }
		// }

		visited[startVertex] = true;
		queue.add(startVertex);
		
		System.out.println("BFS of the given graph is : ");
		while(!queue.isEmpty()) {
			startVertex = queue.poll();
			System.out.print(startVertex+" ");
			for(int i : adjList[startVertex]) {
				if(visited[i] == false) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

	public static void main(String args[]) {
		Bfs g = new Bfs(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		// g.addEdge(2, 3);
		// g.addEdge(3, 3);
		g.addEdge(3, 0);

		System.out.println("Following is Breadth First Traversal "+ "(starting from vertex 2)");
		g.bfs(2);
	}
}