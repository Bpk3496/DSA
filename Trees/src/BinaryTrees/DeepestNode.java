package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestNode {

    public static Node deepestNode(Node root)
    {
        Node tmp = null;
        if (root == null)
            return null;
 
        // Creating a Queue
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
 
        // Iterates untill queue become empty
        while (!q.isEmpty()) 
        {
            tmp = q.poll();
            if (tmp.left != null)
                q.offer(tmp.left);
            if (tmp.right != null)
                q.offer(tmp.right);
        }
        return tmp;
    }
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(9);
        System.out.println(deepestNode(root).data);
	}

}
