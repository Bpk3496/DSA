package BinaryTrees;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {
	
	Node root; 

	public BinaryTree() {
		root = null;
	}
	
	//----------------------------------------------------recursive code----------------------------------------------------//
	
	public void preOrderTraversal(Node node) {
		if(node == null) return;
		
		System.out.print(node.data  + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
	public void postOrderTraversal(Node node) {
		if(node == null) return;
		
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.data+ " ");
	}
	
	public void inOrderTraversal(Node node) {
		if(node == null) return;
		
		inOrderTraversal(node.left);
		System.out.print(node.data+ " ");
		inOrderTraversal(node.right);
	}

	//----------------------------------------------------Iterative code----------------------------------------------------//
	
	public ArrayList<Integer> preOrderTraversalIterative(Node node) {
		ArrayList<Integer> result  = new ArrayList<>();
		if(node == null) return result;
		
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		
		while(!stack.isEmpty()) {
			Node tempNode = stack.pop();
			result.add(tempNode.data);
			// note we add right then left since at the top of the stack we want to process the left first
			if(tempNode.right != null)
				stack.push(tempNode.right);
			if(tempNode.left!= null)
				stack.push(tempNode.left);
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		
			BinaryTree tree = new BinaryTree();
			
			tree.root = new Node(1); 
	        tree.root.left = new Node(2); 
	        tree.root.right = new Node(3); 
	        tree.root.left.left = new Node(4); 
	        tree.root.left.right = new Node(5);
	        tree.root.right.left = new Node(6);
	        tree.root.right.right = new Node(7);
	        
			System.out.println("Preorder traversal of binary tree is "); 
			tree.preOrderTraversal(tree.root);
	        System.out.println("\nInorder traversal of binary tree is "); 
	        tree.postOrderTraversal(tree.root);
	        System.out.println("\nPostorder traversal of binary tree is "); 
	        tree.inOrderTraversal(tree.root);
	        System.out.println("\nIterative Preorder traversal of binary tree is "); 
	        System.out.println(tree.preOrderTraversalIterative(tree.root));
	}

}
