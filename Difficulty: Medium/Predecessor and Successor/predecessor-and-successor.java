/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
         ArrayList<Node> list = new ArrayList<>();
         list.add(new Node(Integer.MIN_VALUE));
         list.add(new Node(Integer.MAX_VALUE));
         helper(root,key,list);
         
         if(list.get(1).data==Integer.MAX_VALUE)list.set(1,null);
         if(list.get(0).data==Integer.MIN_VALUE)list.set(0,null);
         return list;
    }
    public void helper(Node root,int key,ArrayList<Node> list){
        if(root==null)return;
        
        if(root.data>key){
            if(list.get(1).data>root.data){
                list.set(1,root);
            }
        }
        if(root.data<key){
            if(list.get(0).data<root.data){
                list.set(0,root);
            }
        }
        helper(root.left,key,list);
        helper(root.right,key,list);
    }
}