/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
} */

class Solution {
    int max = -1;
    int findCeil(Node root, int x) {
        // code here
        if(root==null){
            return max;
        }
        
        if(root.data>=x){
            max = root.data;
            findCeil(root.left,x);
        }else{
            findCeil(root.right,x);
        }
        
        return max;
    }
}