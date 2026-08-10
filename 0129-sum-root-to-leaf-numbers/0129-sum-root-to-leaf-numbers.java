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
    public int helper(TreeNode root,StringBuilder sb){
        if(root==null)return 0;

        sb.append(root.val);
        if(root.left==null && root.right==null){
            int num = Integer.parseInt(new StringBuilder(sb).toString());
            sb.deleteCharAt(sb.length()-1);
            return num;
        }
        int left=helper(root.left,sb);
        int right=helper(root.right,sb);

        sb.deleteCharAt(sb.length()-1);

        return left+right;
    }
    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return helper(root,sb);
    }
}