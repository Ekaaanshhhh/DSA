/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */
class Solution {
    public boolean isBST(Node root) {
        // code here
        int largest = Integer.MAX_VALUE;
        int smallest = Integer.MIN_VALUE; 
        return helper(root,largest,smallest);
    }
    public boolean helper(Node root,int largest,int smallest){
        if(root==null)return true;
        
        if(root.data<=smallest || root.data>=largest)return false;
        
        boolean checkleft = helper(root.left,root.data,smallest);
        boolean checkright = helper(root.right,largest,root.data);
        
        return checkleft&&checkright;
    }
}