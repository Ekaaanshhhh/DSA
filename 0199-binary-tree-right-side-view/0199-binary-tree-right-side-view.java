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
    public void helper(List<Integer> ans,TreeNode root,int level,HashSet<Integer> set){
        if(root==null){
            return;
        }
        if(!set.contains(level)){
        ans.add(root.val);
        set.add(level);
        }
        helper(ans,root.right,level+1,set);
        helper(ans,root.left,level+1,set);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        if(root==null)return ans;
        helper(ans,root,0,set);
        return ans;
    }
}