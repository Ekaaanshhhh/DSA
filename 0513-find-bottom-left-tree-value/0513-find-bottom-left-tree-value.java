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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode leftmost  = null;
        q.add(root);
        while(!q.isEmpty()){
            int k = q.size();
            leftmost = q.remove();
            if(leftmost.left!=null)q.add(leftmost.left);
            if(leftmost.right!=null)q.add(leftmost.right);
            for(int i=1;i<k;i++){
                TreeNode top = q.remove();
                if(top.left!=null)q.add(top.left);
                if(top.right!=null)q.add(top.right);
            }
        }
        return leftmost.val;
    }
}