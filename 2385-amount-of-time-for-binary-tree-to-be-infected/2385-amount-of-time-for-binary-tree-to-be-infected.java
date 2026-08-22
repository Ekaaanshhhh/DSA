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
    class Pair{
        TreeNode root;int time;
        public Pair(TreeNode root,int time){
            this.root = root;
            this.time = time;
        }
    }
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        while(!q.isEmpty()){
            int k = q.size();
            for(int i=0;i<k;i++){
                TreeNode top = q.remove();
                if(top.left!=null){
                    q.add(top.left);
                    map.put(top.left,top);
                }
                if(top.right!=null){
                    q.add(top.right);
                    map.put(top.right,top);
                }
            }
        }
        TreeNode s = find(root,start);
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(s,0));
        HashSet<TreeNode> set = new HashSet<>();
        set.add(s);
        int min_time = 0;
        while(!que.isEmpty()){
            Pair top = que.remove();
            min_time = Math.max(top.time,min_time);
            if(map.containsKey(top.root)){
                if(!set.contains(map.get(top.root))){
                    set.add(map.get(top.root));
                    que.add(new Pair(map.get(top.root),top.time+1));
                }
            }
                if(top.root.left!=null && !set.contains(top.root.left)){
                    set.add(top.root.left);
                    que.add(new Pair(top.root.left,top.time+1));
                }
                if(top.root.right!=null && !set.contains(top.root.right)){
                    set.add(top.root.right);
                    que.add(new Pair(top.root.right,top.time+1));
                }
        }

        return min_time;
    }
    public TreeNode find(TreeNode root,int val){
        if(root==null)return null;

        if(root.val==val)return root;
        TreeNode left = find(root.left,val);
        TreeNode right = find(root.right,val);

        if(left==null)return right;
        else return left;
    }
}