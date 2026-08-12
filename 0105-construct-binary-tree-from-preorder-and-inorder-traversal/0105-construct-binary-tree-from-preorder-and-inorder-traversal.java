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
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = null;
        root = helper(preorder,inorder,map,root,0,inorder.length-1);
        return root;
    }
    public TreeNode helper(int pre[],int in[],HashMap<Integer,Integer> map,TreeNode root,int low,int high){
        if(low>high)return null;
        if(idx>=in.length)return null;
        int val = pre[idx];
        root = new TreeNode(val);
        int mid = map.get(val);
        idx++;

        root.left = helper(pre,in,map,root.left,low,mid-1);
        root.right = helper(pre,in,map,root.right,mid+1,high);

        return root;
    }
}