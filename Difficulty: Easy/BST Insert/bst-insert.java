/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public Node insert(Node root, int key) {
        // code here
        if(root==null){
            root = new Node(key);
            return root;
        }
        
        if(key>root.data){
            root.right = insert(root.right,key);
        }
        
        else{
            root.left = insert(root.left,key);
        }
        
        return root;
    }
}
