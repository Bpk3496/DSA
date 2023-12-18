import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int curr;
    int parent;
    Node(int s, int e) {
        this.curr = s;
        this.parent = e;
    }
}

class CycleDetectionUndirected {
    private  int vertex;
    private static ArrayList<ArrayList<Integer>> adjList;

    CycleDetectionUndirected(int v) {
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
    
    private static boolean checkForCycle(ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, -1));
        visited[start] = true;

        while(!queue.isEmpty()) {
            int curr = queue.peek().curr;
            int parent = queue.peek().parent;
            queue.remove();

            for(int i : adjList.get(curr)) {
                if(visited[i] == false) {
                    queue.add(new Node(i, curr));
                    visited[i] = true;
                 }
                else if(i != parent) {
                    System.out.println("cycle is formed at the node: "+ i);
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean isCycle(ArrayList<ArrayList<Integer>> adjList, int vertex) { 
        boolean[] visited = new boolean[vertex];
        for(int i = 0; i < vertex; i++) { /* can be used for disconnected components*/
            if(!visited[i]) {
                if(checkForCycle(adjList, visited, i) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        
        CycleDetectionUndirected c = new CycleDetectionUndirected(7);
            addEdge(0, 1);
            addEdge(0, 2);
            //  addEdge(1, 2);
            addEdge(2, 3);
            // addEdge(3, 3);
            addEdge(4, 0);
            addEdge(5, 6);
            addEdge(6, 3);

        System.out.println("The given graph  is cyclic ?:" + isCycle(adjList, 7));
        
    }
}