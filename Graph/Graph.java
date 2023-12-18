import java.util.ArrayList;
import java.util.Scanner;

class Graph {
    public static void addEdge(ArrayList<ArrayList<Integer>> adjList, int left, int right) {
        adjList.get(left).add(right);
        adjList.get(right).add(left);
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> adjList) {
        for(int i=0; i< adjList.size(); i++) {
            System.out.print(i+"->");
            for(int j =0; j < adjList.get(i).size();j++) {
                System.out.print(adjList.get(i).get(j)+"->");
            }
            System.out.println();
        }
    }

    
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i =0; i < 5; i++) 
            adjList.add(new ArrayList<>());
        
        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 4);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 1, 3);
        addEdge(adjList, 1, 4);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 3, 4);
        
        printGraph(adjList);
    }
}