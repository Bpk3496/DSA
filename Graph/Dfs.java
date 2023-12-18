import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
public class Dfs {
    private  int vertex;
    private static ArrayList<ArrayList<Integer>> adjList;

    Dfs(int v) {
        this.vertex = v;
        adjList = new ArrayList<>();
        for(int i =0; i < vertex; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }

    public static void addEdge(int left, int right) {
        adjList.get(left).add(right);
        adjList.get(right).add(left);
    }

    private static void dfsUtil(int node, boolean visited[], ArrayList<Integer> result) {
        result.add(node);
        System.out.println(node);
        visited[node] = true;
        for(int i: adjList.get(node)) {
            if(!visited[i]) {
                dfsUtil(i, visited, result);
            }
        }
    }

    private static ArrayList<Integer> dfs(int vertex) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean visited[] = new boolean[vertex];
        dfsUtil(3, visited, result);
        return result;
    }

    private static void dfs_iter(int start, int size) {
		Stack<Integer> s = new Stack<Integer>();
		s.add(start);
		boolean visited[] = new boolean[size];
		visited[start] = true;
		
		while(!s.isEmpty()) {
			int temp = s.pop();
			System.out.println(temp+" ");
			
			for(int i=0;i< adjList.get(temp).size(); i++) {
				int traversedNode = adjList.get(temp).get(i);
				if(visited[traversedNode] != true) {
					s.push(traversedNode);
					visited[traversedNode] = true;
				}
			}
			
			System.out.println("traversed the list");
		}
		
	}

    public static void main(String args[]) {
        
        Dfs g = new Dfs(7);
        
        addEdge(0, 1);
		addEdge(0, 2);
		addEdge(1, 2);
		addEdge(2, 0);
		addEdge(2, 3);
		addEdge(3, 3);
		addEdge(4, 0);
		addEdge(5, 6);
        addEdge(6, 3);
		
		dfs_iter(2,7);

		dfs(7);
        
        System.out.println(adjList);
        ArrayList<Integer> result = dfs(7);
        System.out.println(result);
        
    }
}
