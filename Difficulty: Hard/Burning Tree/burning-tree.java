/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    class Pair{
        Node root;int dist;
        public Pair(Node root,int dist){
            this.root = root;
            this.dist = dist;
        }
    }
    public void bfs(Node root,Queue<Node> q,HashMap<Node,Node> map){
        q.add(root);
        while(!q.isEmpty()){
            int k= q.size();
            for(int i=0;i<k;i++){
                Node top = q.remove();
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
    public Node find(Node root,int t){
        if(root==null)return null;
        
        if(root.data==t)return root;
        Node left = find(root.left,t);
        Node right = find(root.right,t);
        if(left==null)return right;
        else return left;
    }
    public int minTime(Node root, int t) {
        // code here
        Node target = find(root,t);
        Queue<Node> que = new LinkedList<>();
        HashMap<Node,Node> map = new HashMap<>();
        bfs(root,que,map);
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(target,0));
        HashSet<Node> set = new HashSet<>();
        set.add(target);
        int time=0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            time = Math.max(time,p.dist);
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
        return time;
        
    }
}