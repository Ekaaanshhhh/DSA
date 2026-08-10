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
    int ans=0;
    public void helper(TreeNode root,StringBuilder sb){
        if(root==null)return;

        sb.append(root.val);
        if(root.left==null && root.right==null){
            ans = ans+Integer.parseInt(new StringBuilder(sb).toString());
        }
        else{
            helper(root.left,sb);
            helper(root.right,sb);
        }
        sb.deleteCharAt(sb.length()-1);
    }
    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root,sb);
        return ans;
    }
}