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
    int dia = 0;
    public int height(TreeNode root){
        if(root==null)return 0;

        int left = height(root.left);
        int right = height(root.right);
        dia = Math.max(left+right,dia);

        return Math.max(left,right)+1;
    }

    // public  int helper(TreeNode root){
    //     if(root==null)return 0;

    //     int left = height(root.left);
    //     int right = height(root.right);
    //     dia = Math.max(left+right,dia);

    //     helper(root.left);
    //     helper(root.right);
        
    // }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return dia;
    }
}