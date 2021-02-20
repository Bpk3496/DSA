package BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BottomViewOfBT {

	static HashMap<Node, Integer > node_distance = new HashMap<>();
	
	public void topView(Node root) {
		
		if(root == null)
			return ;
		
		node_distance.put(root,0);
		traverse(root,0);
		
		/* <distance(encountered for the first time), data> */
		HashMap<Integer, Integer>  level_firstview = new HashMap<>();
		level_firstview.put(root.data, 0);
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			
			if(temp.left != null) {
				int dist = node_distance.get(temp.left);
//				if(level_firstview.get(dist) == null) {
					level_firstview.put(dist, temp.left.data);
				queue.add(temp.left);
//				}
			}

			if(temp.right != null) {
				int dist = node_distance.get(temp.right);
//				if(level_firstview.get(dist) == null) {
					level_firstview.put(dist, temp.right.data);
				queue.add(temp.right);
//				}
			}
		}


		for(Node temp: node_distance.keySet())
			System.out.println(node_distance.get(temp)+ " "+temp.data);
		System.out.println("-------------------------------------");
		for(int dist : level_firstview.keySet())
			System.out.println("dist "+ dist +" value "+ level_firstview.get(dist));
	
	}
	
	
	public static void traverse(Node root, int level) {
		if(root == null)
			return ;
		
		if(root.left !=  null) { 
			node_distance.put(root.left, level-1);
			traverse(root.left, level-1);
		}
		
		if(root.right !=  null) {
			node_distance.put(root.right, level+1);
			traverse(root.right, level+1);
		}
	}

	public static void main(String[] args) {
		
		BottomViewOfBT obj = new BottomViewOfBT();
		Node root = new Node();
        
		root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        
        System.out.println("Following are nodes in top view of Binary Tree"); 
        obj.topView(root); 
	}

}
