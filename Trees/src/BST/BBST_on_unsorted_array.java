import java.util.*;

class Node {
    int val;
    Node left;
    
    Node right;
    Node() {
    }   
     
    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class BST {
    private static void preorder(Node root) {
        if(root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
      queue.add(root);
      while(!queue.isEmpty()) {
      	int size = queue.size();        
        	for(int i=0; i<size;i++) {
              Node temp = queue.poll();
            	System.out.print(temp.val);
              	System.out.print(" ");
              if(temp.left != null)
              	queue.add(temp.left);
              if(temp.right != null)
              	queue.add(temp.right);
            }
        System.out.println("-------------------------");
      }
    }
    private static Node constructBBST(int[] nums, int left, int right) {
        if(left > right) {
          return null;
        } 	
      int mid = (left+right)/2;
      Node root = new Node(nums[mid]);
      root.left = constructBBST(nums, left, mid-1);
      root.right = constructBBST(nums, mid+1, right);
      return root;
    }
    public static void main(String args[]) {
        int arr[] = {8, 6 , 12, 18, 34, 23, 3};
        Arrays.sort(arr);
        Node root = constructBBST(arr, 0, arr.length-1);
        preorder(root);
    }
}