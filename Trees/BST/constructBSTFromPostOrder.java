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
    private static void inorder(Node root) {
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    private static Node constructBSTFromPostOrder(int[] nums, int left, int right) {
        if(left > right) return null;
        
        Node root =  new Node(nums[right]);
        int i;
        for(i = right-1; i >=0; i--) {
            if(nums[i]<nums[right])
                break;
        }

        root.left = constructBSTFromPostOrder(nums, left, i);
        root.right = constructBSTFromPostOrder(nums, i+1, right-1);
    
        return root;
    }
    public static void main(String args[]) {
        Node root = new Node();
        int arr[] = {8, 6 , 12, 18, 34, 23, 3};
        Arrays.sort(arr);
        root = constructBSTFromPostOrder(arr, 0, arr.length-1);
        inorder(root);
    }
}