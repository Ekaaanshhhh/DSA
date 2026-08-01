/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class Pair{
        TreeNode root;
        int dist;
        public Pair(TreeNode root,int dist){
            this.root=root;
            this.dist = dist;
        }
    }
    public void bfs(Queue<TreeNode> q,TreeNode root,HashMap<TreeNode,TreeNode> map){
        q.add(root);
        while(!q.isEmpty()){
            int k = q.size();
            for(int i=0;i<k;i++){
            TreeNode top = q.remove();
            if(top.left!=null){
                map.put(top.left,top);
                q.add(top.left);
            }
            if(top.right!=null){
                map.put(top.right,top);
                q.add(top.right);
            }
            }
        }  
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Queue<TreeNode> que = new LinkedList<>();
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        bfs(que,root,map);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(target,0));
        HashSet<TreeNode> set = new HashSet<>();
        set.add(target);
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            Pair p = q.remove();
            if(p.dist==k)ans.add(p.root.val);
            if(map.containsKey(p.root) && !set.contains(map.get(p.root))){
                q.add(new Pair(map.get(p.root),p.dist+1));
                set.add(map.get(p.root));
            }
            if(p.root.left!=null && !set.contains(p.root.left)){
                q.add(new Pair(p.root.left,p.dist+1));
                set.add(p.root.left);
            }
            if(p.root.right!=null && !set.contains(p.root.right)){
                q.add(new Pair(p.root.right,p.dist+1));
                set.add(p.root.right);
            }
        }
        return ans;
    }
}