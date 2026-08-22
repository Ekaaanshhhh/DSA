class Solution {
    class DisjointSet{
        int parent[];
        public DisjointSet(int n){
            parent = new int[n];
            for(int i=0;i<parent.length;i++){
                parent[i]=i;
            }
        }

        public void findUnion(int u,int v){
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);
            if(ulp_u==ulp_v)return;

            parent[ulp_v]=ulp_u;
        }

        public int findParent(int node){
            if(node==parent[node])return node;

            return parent[node]=findParent(parent[node]);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int z = connections.length;
        if(z<n-1)return -1;
        for(int i=0;i<connections.length;i++){
            int u =connections[i][0];
            int v =connections[i][1];
            ds.findUnion(u,v);
        }
        int cnt=0;
        for(int i=0;i<ds.parent.length;i++){
            if(ds.parent[i]==i)cnt++;
        }
        return cnt-1;
    }
}