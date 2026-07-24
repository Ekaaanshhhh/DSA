/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    int getCount(Node root, int l, int h) {
        // Your code here
        if(root==null){
            return 0;
        }
        
        int left = getCount(root.left,l,h);
        int right = getCount(root.right,l,h);
        
        if(root.data>=l && root.data<=h){
            return left+right+1;
        }else{
            return left+right;
        }
    }
}