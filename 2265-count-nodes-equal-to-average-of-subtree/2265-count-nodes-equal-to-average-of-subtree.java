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
    public int helper2(TreeNode root){
        if(root==null)return 0;
        int left = helper2(root.left);
        int right = helper2(root.right);
        return left+right+1;
    }
    public int helper(TreeNode root,int count[]){
        if(root==null)return 0;

        int left = helper(root.left,count);
        int right = helper(root.right,count);
        int c = helper2(root);
        if((left+right+root.val)/c == root.val)count[0]++;

        return left+right+root.val;
    }
    public int averageOfSubtree(TreeNode root) {
        int count[]={0};

        helper(root,count);
        return count[0];
    }
}