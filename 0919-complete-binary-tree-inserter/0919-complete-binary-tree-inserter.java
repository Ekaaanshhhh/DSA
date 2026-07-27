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
class CBTInserter {
    TreeNode root = new TreeNode();
    public CBTInserter(TreeNode root) {
        this.root=root;
    }
    
    public int insert(int val) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode newnode = new TreeNode(val);
        if(root==null){
            root = newnode;
        }
        q.add(root);
        while(!q.isEmpty()){
            int k = q.size();
            for(int i=0;i<k;i++){
                TreeNode top = q.remove();
                if(top.left==null){
                    top.left=newnode;
                    return top.val;
                }
                else if(top.right==null){
                    top.right=newnode;
                    return top.val;
                }

                if(top.left!=null)q.add(top.left);
                if(top.right!=null)q.add(top.right);
            }
        }
        return -1;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */