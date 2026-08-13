/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode root;TreeNode parent;
        public Pair(TreeNode root,TreeNode parent){
            this.root = root;
            this.parent = parent;
        }
    }
    public int sumEvenGrandparent(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        if(root==null)return 0;
        q.add(new Pair(root,null));
        int sum = 0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            TreeNode toproot = p.root;
            TreeNode parent = p.parent;

            if(toproot.left!=null){
                q.add(new Pair(toproot.left,toproot));
                if(parent!=null && parent.val%2==0){
                    sum = sum+toproot.left.val;
                }
            }
            if(toproot.right!=null){
                q.add(new Pair(toproot.right,toproot));
                if(parent!=null && parent.val%2==0){
                    sum = sum+toproot.right.val;
                }
            }
        }
        return sum;
    }
}