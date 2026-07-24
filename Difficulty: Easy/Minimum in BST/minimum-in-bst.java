/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
*/

class Solution {
    public int minValue(Node root) {
        // code here
        Node dummy = root;
        while(dummy.left!=null){
            dummy = dummy.left;
        }
        
        return dummy.data;
    }
}