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
    public int helper(TreeNode root,int max){
        if(root==null)return 0;

        int ans=0;
        if(root.val>=max){
            max = root.val;
            ans=1;
        }
        ans = ans+helper(root.left,max)+helper(root.right,max);

        return ans;

    }
    public int goodNodes(TreeNode root) {
        return helper(root,Integer.MIN_VALUE);
    }
}