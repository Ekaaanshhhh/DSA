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
    public void helper(TreeNode root,int target, List<List<Integer>> ans,List<Integer> path,int sum){
        if(root==null)return;

        sum = sum+root.val;
        path.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==target)ans.add(new ArrayList<>(path));
            sum = sum-root.val;
            path.remove(path.size()-1);
            return;
        }
        helper(root.left,target,ans,path,sum);
        helper(root.right,target,ans,path,sum);

        sum = sum-root.val;
        path.remove(path.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root,targetSum,ans,path,0);
        return ans;
    }
}