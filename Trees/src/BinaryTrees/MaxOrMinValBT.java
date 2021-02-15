package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxOrMinValBT {

	int maxValueRecursion(Node root)
	{
		int max = Integer.MIN_VALUE;
		
		if(root == null) return max;
		
		int leftMax = maxValueRecursion(root.left); 
		int rightMax = maxValueRecursion(root.right);
		
		if(leftMax > rightMax) 
			max = leftMax;
		else
			max = rightMax;
		if(root.data > max )
			max = root.data;
		
		return  max;
	}
	
	int maxValueIterative(Node root) {
		int max = Integer.MIN_VALUE;
		
		if(root == null) return max;
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node tempNode = queue.poll();
			if(tempNode.data > max)
				max = tempNode.data;
			
			if(tempNode.left != null)
				queue.offer(tempNode.left);

			if(tempNode.right != null)
				queue.offer(tempNode.right);
		}
		return max;
	}
	public static void main(String[] args) {
		
		MaxOrMinValBT obj = new MaxOrMinValBT();
		
		Node root = new Node(1); 
		root.left = new Node(2); 
		root.right = new Node(7); 
        root.left.left = new Node(6); 
        root.left.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        
        System.out.println("maxValueRecursion "+obj.maxValueRecursion(root));
        System.out.println("maxValueIterative "+obj.maxValueIterative(root));
        
	}
}
