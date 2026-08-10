class Solution {
    class Pair{
        int node;
        int wt;
        Pair(int node,int wt){
            this.node = node;
            this.wt = wt;
        }
    }
    class Element implements Comparable<Element>{
        int wt;
        int node;
        int parent;
        public Element(int w,int n,int p){
            wt = w;
            node = n;
            parent = p;
        }
        public int compareTo(Element that){
            return Integer.compare(this.wt,that.wt);
        }
    }
    public int spanningTree(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        int vis[] = new int[V];
        return prim(adj,vis);
    }
    public int prim(ArrayList<ArrayList<Pair>> adj,int vis[]){
        PriorityQueue<Element> pq = new PriorityQueue<>(); 
        pq.add(new Element(0,0,-1));
        int ans = 0;
        while(!pq.isEmpty()){
            Element e = pq.remove();
            int node = e.node;
            int wt = e.wt;
            int parent = e.parent;
            if(vis[node]==1)continue;
            vis[node]=1;
            ans = ans+wt;
            for(Pair j:adj.get(node)){
                if(vis[j.node]==0){
                    pq.add(new Element(j.wt,j.node,node));
                }
            }
        }
        return ans;
    }
}
