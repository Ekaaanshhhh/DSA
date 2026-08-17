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
    // public TreeNode helper(TreeNode r1,TreeNode r2){
    //     if(r1==null)return null;
    //     TreeNode left = helper(r1.left,r2.left);
    //     TreeNode right = helper(r1.right,r2.right);

    //     if(left==null && right==null && r1.val==0){
    //         return r2 = null;
    //     }
    //     return r2 = new TreeNode(r1.val);
    // }
    public TreeNode pruneTree(TreeNode root) {
       if(root==null)return null;

       root.left = pruneTree(root.left);
       root.right = pruneTree(root.right);

       if(root.val==0 && root.left==null && root.right==null){
        return null;
       }
       return root;
    }
}