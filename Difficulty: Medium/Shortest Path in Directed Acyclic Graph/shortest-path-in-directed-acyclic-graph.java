class Solution {
    class Pair{
        int node;
        int wt;
        public Pair(int node,int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    class Element implements Comparable<Element>{
        int node;
        int wt;
        public Element(int node,int wt){
            this.node = node;
            this.wt = wt;
        }
        
        public int compareTo(Element that){
            return Integer.compare(this.wt,that.wt);
        }
    }
    public ArrayList<Integer> shortestPath(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++){
            ans.add((int)1e9);
        }
        ans.set(0,0);
        PriorityQueue<Element> q = new PriorityQueue<>();
        q.add(new Element(0,0));
        while(!q.isEmpty()){
            Element e = q.remove();
            int node = e.node;
            int weight = e.wt;
            for(Pair p:adj.get(node)){
                if(weight>ans.get(p.node))continue;
                int weight_taken = weight+p.wt;
                if(ans.get(p.node)>weight_taken){
                    ans.set(p.node,weight_taken);
                    q.add(new Element(p.node,weight_taken));
                }
            }
        }
        
        for(int i=0;i<ans.size();i++){
            if(ans.get(i)==(int)1e9){
                ans.set(i,-1);
            }
        }
        
        return ans;
    }
}