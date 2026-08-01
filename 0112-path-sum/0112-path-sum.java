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
    int sum=0;
     public boolean helper(TreeNode root, int target)
     {
        if(root==null)
        {
            return false;
        }
        sum=sum+root.val;
        
        boolean left=helper(root.left,target);
        boolean right=helper(root.right,target);
        if(sum==target&&(root.left==null && root.right==null))return true;
        sum=sum-root.val;
        
        return left||right;
     }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root,targetSum);
    }
}