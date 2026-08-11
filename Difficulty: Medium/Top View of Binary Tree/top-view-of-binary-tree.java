/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    class Pair{
        Node root;
        int hd;
        public Pair(Node root,int hd){
            this.root = root;
            this.hd = hd;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        // code here
        Queue<Pair> q = new LinkedList<>();
        if(root==null)return new ArrayList<>();
        q.add(new Pair(root,0));
        TreeMap<Integer,Integer> map = new TreeMap<>();
        while(!q.isEmpty()){
            int k = q.size();
            for(int i=0;i<k;i++){
                Pair p = q.remove();
                Node top = p.root;
                int hd = p.hd;
                if(!map.containsKey(hd)){
                    map.put(hd,top.data);
                }
                if(top.left!=null)q.add(new Pair(top.left,hd-1));
                if(top.right!=null)q.add(new Pair(top.right,hd+1));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int key:map.keySet()){
            ans.add(map.get(key));
        }
        
        return ans;
    }
}