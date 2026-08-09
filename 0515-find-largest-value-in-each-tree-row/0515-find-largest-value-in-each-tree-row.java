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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        if(root==null)return list;
        while(!q.isEmpty()){
            int k = q.size();
            int largest = Integer.MIN_VALUE;
            for(int i=0;i<k;i++){
                TreeNode top = q.remove();
                largest = Math.max(largest,top.val);
                if(top.left!=null)q.add(top.left);
                if(top.right!=null)q.add(top.right);
            }
            list.add(largest);
        }
        return list;
    }
}