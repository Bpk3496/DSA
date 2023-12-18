package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class Searching {

	boolean  SearchingRecursion(Node root, int element) {
		if(root == null)
			return false;
		if(root.data == element)
			return true;
				
		return (SearchingRecursion(root.left, element) || SearchingRecursion(root.right, element));
	}
	
	boolean  SearchingIterative(Node root, int element) {
		if(root == null) return false;
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node tempNode = queue.poll();
			
			if(tempNode.data == element) 
				return true;
			
			if(tempNode.left != null) 
				queue.offer(tempNode.left);
			
			if(tempNode.right != null) 
				queue.offer(tempNode.right);
			
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		Searching obj = new Searching();
		
		Node root = new Node(1); 
		root.left = new Node(2); 
		root.right = new Node(7); 
        root.left.left = new Node(6); 
        root.left.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        
        System.out.println("maxValueRecursion "+obj.SearchingRecursion(root, 8));
        System.out.println("maxValueIterative "+obj.SearchingIterative(root,7));
        
	}
}
