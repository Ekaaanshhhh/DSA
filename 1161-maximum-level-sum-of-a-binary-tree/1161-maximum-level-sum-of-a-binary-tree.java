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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxsum = Integer.MIN_VALUE;
        int maxidx = 1;
        int lev=1;
        while(!q.isEmpty()){
            int k = q.size();
            int sum=0;
            for(int i=0;i<k;i++){
                TreeNode top = q.remove();
                sum = sum+top.val;
                if(top.left!=null)q.add(top.left);
                if(top.right!=null)q.add(top.right);
            }
            if(sum>maxsum){
                maxsum = sum;
                maxidx = lev;
            }
            lev++;
            sum=0;
        }
        return maxidx;
    }
}