package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class LeftViewOfBT {

	static boolean levelArr[] = new boolean[1000];
	
	public static void main(String[] args) {
	
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        for(int i =0;i< levelArr.length;i++) {
        	levelArr[i] = false;
        }
        
         printLeftView(root, 0);
	}

	private static void  printLeftView(Node root, int level) {
		if( root == null)
			return ;
		
		
		if(levelArr[level] == false) {
			System.out.println(root.data);
			levelArr[level] = true;
		}
		
		printLeftView(root.left, level+1);
		printLeftView(root.right, level+1);
		
	}

}
