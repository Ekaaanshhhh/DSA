class Solution {
    class DisjointSet{
        int parent[];
        public DisjointSet(int n){
            parent = new int[n];
            for(int i=0;i<parent.length;i++)parent[i]=i;
        }

        public int findParent(int n){
            if(parent[n]==n){
                return n;
            }
            return parent[n] = findParent(parent[n]);
        }

        public void findUnion(int u,int v){
            int ulp_u = parent[u];
            int ulp_v = parent[v];
            if(ulp_u==ulp_v)return;

            parent[ulp_v]=ulp_u;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length);
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0]-1;
            int v = edges[i][1]-1;
            if(ds.findParent(u)==ds.findParent(v))return edges[i];

            ds.findUnion(u,v);
        }
        return new int[0];
    }
}