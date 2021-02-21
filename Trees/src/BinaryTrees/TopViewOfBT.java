package BinaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 
// A Pair class
class Pair
{
    public final Node node;       // first field of a pair
    public final int level;      // second field of a pair
 
    // Constructs a new Pair with specified values
    Pair(Node node, int level)
    {
        this.node =  node;
        this.level= level;
    }
    
    public Node getNode() {
    	return node;
    }
    public int getLevel() {
    	return this.level;
    }
}

public class TopViewOfBT {

	static /* Recursive function to perform preorder traversal on the tree and fill the map. 
	 * Here, the node has `dist` horizontal distance from the tree's root, and the level represents the node's level. */
	
	Map<Integer, ArrayList<Pair>> map = new HashMap<>();
	
    public static void buildTopView(Node root, int dist, int level) {
        if (root == null) {
            return;
        }
        /* if the current level is less than the maximum level seen so far for the 
         * same horizontal distance, or if the horizontal distance  is seen for the first time, update the map */
        if (!map.containsKey(dist)) {
        	Pair pair = new Pair(root, level);
        	ArrayList<Pair> temp = new ArrayList<>();
        	temp.add(pair);
            map.put(dist, temp);
        }
        else {

        	Pair pair = new Pair(root, level);
        	ArrayList<Pair> list  = map.get(dist);
        	list.add(pair);
            map.put(dist, list);
        }
 
        if(root.left != null) {
        	/* recur for the left subtree by decreasing horizontal distance and increasing level by 1 */
        	buildTopView(root.left, dist - 1, level + 1);
        }        	 
 
        if(root.left != null) {
        	/* recur for the right subtree by increasing both level and horizontal distance by 1 */
        	buildTopView(root.right, dist + 1, level + 1);
        }
    }
 
    // Function to print the top view of a given binary tree
    public static void printTopView()
    {
        // traverse the `TreeMap` and print the top view
        for (ArrayList<Pair> obj: map.values()) {
        	Pair temp = obj.get(0);
            System.out.print(temp.getNode().data+ " ");
        }
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(9);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(12);
        root.left.left.right = new Node(23);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(11);
        
 
        buildTopView(root,0,0);
        printTopView();
    }
}






