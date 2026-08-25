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
    public TreeNode helper(TreeNode root,List<TreeNode> list,HashSet<Integer> set){
        if(root==null)return null;

        root.left = helper(root.left,list,set);
        root.right = helper(root.right,list,set);
        if(set.contains(root.val)){
            if(root.left!=null)list.add(root.left);
            if(root.right!=null)list.add(root.right);
            return null;
        }
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int n:to_delete)set.add(n);

        helper(root,ans,set);

        if(!set.contains(root.val))
        ans.add(root);
        return ans;
    }
}