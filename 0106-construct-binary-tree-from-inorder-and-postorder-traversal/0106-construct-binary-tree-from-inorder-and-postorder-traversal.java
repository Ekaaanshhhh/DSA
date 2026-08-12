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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int index[] = {postorder.length-1};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(inorder,postorder,map,null,index,0,inorder.length-1);
    }
    public TreeNode helper(int in[],int pos[],HashMap<Integer,Integer> map,TreeNode root,int index[],int low,int high){
        if(low>high)return null;
        if(index[0]<0)return null;

        int val = pos[index[0]];
        int mid = map.get(val);
        root = new TreeNode(val);
        index[0]--;

        root.right = helper(in,pos,map,root.right,index,mid+1,high);
        root.left = helper(in,pos,map,root.left,index,low,mid-1);

        return root;
    }
}