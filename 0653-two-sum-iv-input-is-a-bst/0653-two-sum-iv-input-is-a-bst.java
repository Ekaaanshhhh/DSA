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
    public void helper1(TreeNode root,HashSet<Integer> set){
        if(root==null)return;

        set.add(root.val);
        helper1(root.left,set);
        helper1(root.right,set);
    }
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        helper1(root,set);
        return helper2(root,set,k);
    }
    public boolean helper2(TreeNode root,HashSet<Integer> set,int k){
        if(root==null)return false;
        if(set.contains(k-root.val) && k-root.val!=root.val)return true;
        boolean left = helper2(root.left,set,k);
        boolean right = helper2(root.right,set,k);

        return left||right;
    }
}