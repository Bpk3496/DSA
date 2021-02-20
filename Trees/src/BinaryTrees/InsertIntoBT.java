package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class InsertIntoBT {

	public Node insert(Node root, int data) {
        
        if(root == null)              
        	return root;
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            
                if(node.left != null)
                    queue.add(node.left);
                else {
                	node.left = new Node(data);
                	return root;
                }
                	
                if(node.right != null)
                    queue.add(node.right);
                else {
                	node.right= new Node(data);
                	return root;
                }
        }
        
        return root;
	}
	
	public void print(Node root) {
		if(root == null)
			return;
		System.out.println(root.data+ " ");
		print(root.left);
		print(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertIntoBT obj = new InsertIntoBT();
		
		Node root = new Node(1); 
		root.left = new Node(2); 
		root.right = new Node(7); 
        root.left.left = new Node(6); 
        root.left.right = new Node(5);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        root.left.left.left= new Node(8);
        root.left.left.right= new Node(9);
        
        obj.insert(root,10);
        obj.print(root);
        
	}

}
