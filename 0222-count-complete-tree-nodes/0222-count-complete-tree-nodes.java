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
    public int getrightheight(TreeNode root){
        int cnt = 1;
        while(root.right!=null){
            cnt++;
            root = root.right;
        }
        return cnt;
    }
    public int getleftheight(TreeNode root){
        int cnt = 1;
        while(root.left!=null){
            cnt++;
            root = root.left;
        }
        return cnt;
    }
    public int countNodes(TreeNode root) {
        if(root==null)return 0;

        int lh = getleftheight(root);
        int rh = getrightheight(root);

        if(lh==rh)return (int)Math.pow(2,lh)-1;

        int left = countNodes(root.left);
        int right = countNodes(root.right);


        return left+right+1;
    }
}