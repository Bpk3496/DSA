import java.util.ArrayList;
import java.util.Stack;

public class CycleDetectionUndirectedDFS {
    private  int vertex;
    private static ArrayList<ArrayList<Integer>> adjList;

    CycleDetectionUndirectedDFS(int v) {
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

    private static boolean cycleDetectionDFSRecur(boolean[] visited, int start, int parent) {
        visited[start] = true;
        for(int i : adjList.get(start)) {
            if(!visited[i]) {
                if(cycleDetectionDFSRecur(visited, i, start))
                    return true;
            }
            else if(parent != i){
                return true;
            }
        }
        return false;
    }

    private static boolean cycleDetectionDFSIter(boolean[] visited, int start) {
        visited[start] = true;
        Stack<Node> stack = new Stack<>();
        stack.add(new Node(start, -1));

        while(!stack.isEmpty()) {
            int curr = stack.peek().curr;
            int par = stack.peek().parent;
            stack.pop();

            for(int i: adjList.get(curr)) {
                if(!visited[i]) {
                    stack.add(new Node(i, curr));
                    visited[i] = true;
                }
                else if(i != par) {
                    System.out.println("cycle is found at the node: "+ i);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycle(int vertex) {
        boolean[] visited = new boolean[vertex];
        for(int i=0; i < vertex; i++) {
            if(!visited[i]) {
                if(cycleDetectionDFSRecur(visited, i, -1)) {
                    System.out.println("cycle is found at the node: "+ i);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycleIter(int vertex) {
        boolean[] visited = new boolean[vertex];
        for(int i=0; i < vertex; i++) {
            if(!visited[i]) {
                if(cycleDetectionDFSIter(visited, i))
                    return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {        
        CycleDetectionUndirectedDFS c = new CycleDetectionUndirectedDFS(10);
        addEdge(0, 1);
        addEdge(0, 2);
        //  addEdge(1, 2);
        addEdge(2, 3);
        // addEdge(3, 3);
        addEdge(4, 0);
        addEdge(5, 6);
        addEdge(6, 3);
        addEdge(7, 8);
        addEdge(8, 9);
        addEdge(9, 7);

        System.out.println("The given graph  is cyclic ?:" + isCycle(10));
        System.out.println("The given graph  is cyclic ?:" + isCycleIter(10));
    }

}
