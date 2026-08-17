class Solution {
    class DisjointSet{
        int parent[];
        public DisjointSet(int n){
            parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }

        public int findParent(int u){
            if(u==parent[u])return u;
            return parent[u]=findParent(parent[u]);
        }

        public void union(int u,int v){
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);
            if(ulp_u==ulp_v)return;

            parent[ulp_u]=ulp_v;
        }
    }
    public int findCircleNum(int[][] isConnected) {
       DisjointSet ds = new DisjointSet(isConnected.length);

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(i>j && isConnected[i][j]==1){
                    ds.union(i,j);
                }
            }
        }

        int cnt = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<ds.parent.length;i++){
            set.add(ds.findParent(i));
        }

        return set.size();
    }
}