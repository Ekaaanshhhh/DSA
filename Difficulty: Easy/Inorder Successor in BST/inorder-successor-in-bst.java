/*
Definition for Node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
};
*/

class Solution {
    public int inOrderSuccessor(Node root, Node k) {
        // code here
        ArrayList<Integer> in = new ArrayList<>();
        helper(root,in);
        if(in.get(in.size()-1)==k.data)return -1;
        for(int i=1;i<in.size();i++){
            if(in.get(i-1)==k.data)return in.get(i); 
        }
        return -1;
    }
    public void helper(Node root,ArrayList<Integer> in){
        if(root==null)return;
        
        
        helper(root.left,in);
        in.add(root.data);
        helper(root.right,in);
    }
}