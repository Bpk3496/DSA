package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfABT {

	public int sizeRecursion(Node tree) {
		if(tree == null) 
			return 0;
		
		int leftSize = sizeRecursion(tree.left);
		int rightSize = sizeRecursion(tree.right);
		
		return leftSize+rightSize+1;
	}
	
	public int sizeIterative(Node tree) {
		if(tree == null) 
			return 0;
		
		int size = 0;
		
		Queue<Node> queue = new LinkedList<>();	
		queue.add(tree);
		 size++;
		 
		 
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			if(temp.left != null) {
				queue.add(temp.left);
				size++;
			}
			if(temp.left != null) {
				queue.add(temp.right);
				size++;
			}
		}
		return size;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SizeOfABT obj = new SizeOfABT();
		
		Node root = new Node(1); 
		root.left = new Node(2); 
		root.right = new Node(7); 
        root.left.left = new Node(6); 
        root.left.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        root.left.left.left= new Node(8);
        root.left.left.right= new Node(9);
        
        System.out.println("size of the tree(recursive methods) is "+obj.sizeRecursion(root));
        
        System.out.println("size of the tree(iterative methods) is "+obj.sizeIterative(root));
	}

}
