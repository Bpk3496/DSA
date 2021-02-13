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
	
	public ArrayList<Integer> inOrderTraversalIterative(Node node) {
		ArrayList<Integer> result = new ArrayList<>();
		
		if(node == null) return result;
		Stack<Node> stack  = new Stack<>();
		
		stack.push(node);
		/* we need this variable in this traversal to keep track of the current node as we use it move till the left most 
		 * node and the when we get null for the current node we can pop the stack which tracks the node which called
		 *  the null pointer, then we move to right of it, if we encounter null we pop the node one level above since we
		 *  finished traversing the entire left side of a node and need to move to its right so before  going we pop add it 
		 *  to list and go and apply the same rules.
		 *  when the stack is empty it means we traversed the entire tree.
		 *  */
		Node currentNode = node; 
 
		while((currentNode != null ) ||  !(stack.isEmpty())) {
			if(currentNode != null ) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			} else {
				currentNode = stack.pop();
				result.add(currentNode.data);
				currentNode = currentNode.right;
			}
		}
		
		return result;
	}
	
	public ArrayList<Integer> postOrderTraversalIterative1Stack(Node node) { /* @tushar reference*/
		ArrayList<Integer> result = new ArrayList<>();    
        if(root == null) return result;
    
        Stack<Node> stack1 = new Stack<>();        
        Node currentNode = node;
        
        while(currentNode != null || !stack1.isEmpty()) {
        	
        	if(currentNode != null) {
        		stack1.push(currentNode);
        		currentNode = currentNode.left;
        	}
        	
        	else {
        		Node tempNode  = stack1.peek().right;
        		
	        		if(tempNode == null) {
	        			tempNode = stack1.pop();
	        			result.add(tempNode.data);
	        			
	        			while(!stack1.isEmpty()  && tempNode == stack1.peek().right) {
	        				tempNode = stack1.pop();
	        				result.add(tempNode.data);
	        			}
	        		}
	        		else 
	        			currentNode = tempNode;
        	}	
        }
       
        return result;
	}
	
	public ArrayList<Integer> postOrderTraversalIterative2Stack(Node node) { // @tech dose reference
		ArrayList<Integer> result = new ArrayList<>();    
        if(root == null) return result;
    
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
      
        stack1.push(root);
      
        while(!stack1.isEmpty()) {
            node = stack1.pop();
            stack2.push(node);
            
            if(node.left != null) 
                stack1.push(node.left);
            if(node.right != null)
                stack1.push(node.right);
            
        }
        
       while(!stack2.isEmpty()) {
            node = stack2.pop();
            result.add(node.data);
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
	        
	        System.out.println("\n Iterative Preorder traversal of binary tree is "); 
	        System.out.println(tree.preOrderTraversalIterative(tree.root));
	        
	        System.out.println("\n Iterative Inorder traversal of binary tree is "); 
	        System.out.println(tree.inOrderTraversalIterative(tree.root));
	        
	        System.out.println("\n Iterative postorder traversal of binary tree using 1 Stack is ");	      
	        System.out.println(tree.postOrderTraversalIterative1Stack(tree.root));
	        
	        System.out.println("\nIterative postorder traversal of binary tree using 2 Stack is ");	      
	        System.out.println(tree.postOrderTraversalIterative2Stack(tree.root));
	}

}
