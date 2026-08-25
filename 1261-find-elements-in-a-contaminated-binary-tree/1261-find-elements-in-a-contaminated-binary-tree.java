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
class FindElements {
    TreeNode root;
    HashSet<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {
        this.root = root;
        helper(root);

    }
    
    public boolean find(int target) {
        return set.contains(target);
    }

    public void helper(TreeNode root){
        if(root==null)return;
        set.add(0);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        root.val=0;
        while(!q.isEmpty()){
            int k = q.size();
            for(int i=0;i<k;i++){
                TreeNode top = q.remove();
                if(top.left!=null){
                    top.left.val = top.val*2+1;
                    q.add(top.left);
                    set.add(top.left.val);
                }
                if(top.right!=null){
                    top.right.val = top.val*2+2;
                    q.add(top.right);
                    set.add(top.right.val);
                }
            }
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */