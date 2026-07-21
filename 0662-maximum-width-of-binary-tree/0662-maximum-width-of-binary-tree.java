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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        root.val=1;
        q.add(root);
        while(!q.isEmpty()){
            int x = q.size();
            for(int i=0;i<x;i++){
            TreeNode top = q.remove();
            int index = top.val;

            if(top.left!=null){
                top.left.val = 2*index;
                q.add(top.left);
            }

            if(top.right!=null){
                top.right.val = 2*index+1;
                q.add(top.right);
            }
            }
        }

        int width = 0;
        q.add(root);

        while(!q.isEmpty()){
            int min = q.peek().val;
            int max = Integer.MIN_VALUE;
            int x = q.size();
            for(int i=0;i<x-1;i++){
                TreeNode top = q.remove();
                if(top.left!=null)q.add(top.left);
                if(top.right!=null)q.add(top.right);
            }
            max = q.peek().val;
            if(q.peek().left!=null)q.add(q.peek().left);
            if(q.peek().right!=null)q.add(q.peek().right);
            q.remove();
            width = Math.max(max-min+1,width);
        }
        return width;
    }
}