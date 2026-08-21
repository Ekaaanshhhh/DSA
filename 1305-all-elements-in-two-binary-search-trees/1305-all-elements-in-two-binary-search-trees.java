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
    public void helper(TreeNode root,List<Integer> list){
        if(root==null)return;
        helper(root.left,list);
        list.add(root.val);
        helper(root.right,list);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
       List<Integer> list1 = new ArrayList<>();
       List<Integer> list2 = new ArrayList<>();
       helper(root1,list1);
       helper(root2,list2);

       list2.addAll(list1);
       Collections.sort(list2);
       return list2;
    }
}