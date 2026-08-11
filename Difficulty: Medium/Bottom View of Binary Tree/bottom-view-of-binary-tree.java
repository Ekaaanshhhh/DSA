/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

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
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        Queue<Pair> q =new LinkedList<>();
        q.add(new Pair(root,0));
        TreeMap<Integer,Integer> map = new TreeMap<>();
        while(!q.isEmpty()){
            int k = q.size();
            for(int i=0;i<k;i++){
                Pair p = q.remove();
                Node top = p.root;
                int hd = p.hd;
                map.put(hd,top.data);
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