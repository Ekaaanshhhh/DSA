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
    int count=0;
    public int helper(TreeNode root){
        if(root==null){
            return Integer.MIN_VALUE;
        }

        int max = Math.max(helper(root.left),helper(root.right));

        if(root.val>=max){
            count++;
            return root.val;
        }
        return Math.max(root.val,max);
    }
    public int countDominantNodes(TreeNode root) {
        helper(root);
        return count;
    }
}