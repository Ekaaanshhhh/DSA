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
    class Element{
        TreeNode root;int dep;
        public Element(TreeNode root,int dep){
            this.root = root;
            this.dep = dep;
        }
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newroot = new TreeNode(val);
            newroot.left = root;
            return newroot;
        }
        Queue<Element> q = new LinkedList<>();
        q.add(new Element(root,1));
        while(!q.isEmpty()){
            Element e = q.remove();
            TreeNode topNode = e.root;
            int dep = e.dep;
            if(dep==depth-1){
                TreeNode left = topNode.left;
                TreeNode right = topNode.right;
                topNode.left = new TreeNode(val);
                topNode.right = new TreeNode(val);
                topNode.left.left = left;
                topNode.right.right = right;
            }
            if(topNode.left!=null)q.add(new Element(topNode.left,dep+1));
            if(topNode.right!=null)q.add(new Element(topNode.right,dep+1));
        }
        return root;
    }
}