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
    public void helper(TreeNode root,List<List<Integer>> ans,List<Integer> path){
        if(root==null)return;

        path.add(root.val);
        if(root.left==null && root.right==null){
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        helper(root.left,ans,path);
        helper(root.right,ans,path);

        path.remove(path.size()-1);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root,ans,path);

        List<String> finalans = new ArrayList<>();
        for(int i=0;i<ans.size();i++){
            StringBuilder sb = new StringBuilder("");
            for(int j=0;j<ans.get(i).size()-1;j++){
                sb.append(ans.get(i).get(j));sb.append("->");
            }
            sb.append(ans.get(i).get(ans.get(i).size()-1));
            finalans.add(sb.toString());
        }
        return finalans;
    }
}