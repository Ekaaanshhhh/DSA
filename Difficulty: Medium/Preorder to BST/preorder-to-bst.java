/*
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
    public Node preToBST(int pre[]) {
        // code here
        Node root = null;
        for(int i=0;i<pre.length;i++){
            root = build(pre[i],root);
        }
        return root;
    }
    public Node build(int val,Node root){
        if(root==null)return new Node(val);
        
        if(val<root.data){
            root.left = build(val,root.left);
        }
        else{
            root.right = build(val,root.right);
        }
        return root;
    }
}