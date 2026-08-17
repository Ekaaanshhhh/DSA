class Solution {
    class DisjointSet{
        int parent[];
        public DisjointSet(int n){
            parent = new int[n];
            for(int i=0;i<parent.length;i++)parent[i]=i;
        }
        
        public int findParent(int u){
            if(u==parent[u])return u;
            return parent[u]=findParent(parent[u]);
        }
        
        public void union(int u,int v){
            if(findParent(u)==findParent(v)){
                return;
            }
            
            parent[findParent(u)]=parent[findParent(v)]; 
        }
    }
    public int spanningTree(int V, int[][] edges) {
        // code here
        //kruskla's algo
        DisjointSet ds = new DisjointSet(V);
        Arrays.sort(edges,Comparator.comparingDouble(o->o[2]));
        int ans=0;
        
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(ds.findParent(u)==ds.findParent(v)){
                continue;
            }
            ans = ans+edges[i][2];
            ds.union(u,v);
        }
        return ans;
    }
}
