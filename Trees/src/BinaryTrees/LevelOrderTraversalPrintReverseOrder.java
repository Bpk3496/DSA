package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversalPrintReverseOrder {

	
	public void levelOrderReverseOrder(Node root) {
		
		if(root == null) 
			return ;
		Queue<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
	
			if(temp.right != null)
				queue.offer(temp.right);
			if(temp.left != null)
				queue.offer(temp.left);
			stack.push(temp);
		}
		
		 while(!stack.isEmpty()) {
			 	System.out.print(stack.pop().data+" ");
	        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LevelOrderTraversalPrintReverseOrder obj = new LevelOrderTraversalPrintReverseOrder();
		
		Node root = new Node(1); 
		root.left = new Node(2); 
		root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right= new Node(7);
        root.left.left.left= new Node(8);
        root.left.left.right= new Node(9);
        root.left.right.left= new Node(10);
        root.left.right.right= new Node(11);
        
        obj.levelOrderReverseOrder(root);
	}
}
