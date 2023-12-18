package BinaryTrees;

public class IdenticalTrees {
	
	Node root1, root2; 

	/* Given two trees, return true if they are  structurally identical */
	
	static boolean identicalTrees(Node a, Node b) { 
		/*1. both empty */
		if (a == null && b == null) 
			return true; 
			
		/* 2. both non-empty -> compare them */
		if (a != null && b != null) 
			return (a.data == b.data 
					&& identicalTrees(a.left, b.left) 
					&& identicalTrees(a.right, b.right)); 

		/* 3. one empty, one not -> false */
		return false; 
	} 

	/* Driver program to test identicalTrees() function */
	public static void main(String[] args) 
	{ 
		Node tree1 = new Node(); 

		tree1.left = new Node(1); 
		tree1.right = new Node(2); 
		tree1.left.left = new Node(3); 
		tree1.left.right = new Node(4); 

		Node tree2 = new Node(1); 
		tree2.left = new Node(2); 
		tree2.right = new Node(3); 
		tree2.left.left = new Node(4); 
		tree2.left.right = new Node(5); 

		if (identicalTrees(tree1, tree2)) 
			System.out.println("Both trees are identical"); 
		else
			System.out.println("Trees are not identical"); 

	} 
} 
