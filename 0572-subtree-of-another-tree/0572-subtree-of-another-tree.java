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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)return false;

        if(root.val==subRoot.val){
            if (check(root,subRoot))return true;
        }

        boolean left = isSubtree(root.left,subRoot);
        boolean right = isSubtree(root.right,subRoot);

        return left||right;
    }
    public boolean check(TreeNode r1,TreeNode r2){
        if(r1==null && r2==null)return true;
        if(r1==null && r2!=null)return false;
        if(r2==null && r1!=null)return false;
        if(r1.val!=r2.val)return false;

        boolean left = check(r1.left,r2.left);
        boolean right = check(r1.right,r2.right);

        return left&&right;
    }
}