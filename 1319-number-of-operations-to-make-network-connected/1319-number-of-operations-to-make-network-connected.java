class Solution {
    class DisjointSet{
        int parent[];
        public DisjointSet(int n){
            parent = new int[n];
            for(int i=0;i<n;i++)parent[i]=i;
        }

        public void findunion(int u,int v){
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);
            if(ulp_u==ulp_v)return;

            parent[ulp_u] = ulp_v;
        }

        public int findParent(int node){
            if(parent[node]==node)return node;
            return parent[node] = findParent(parent[node]);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int z = connections.length;
        if(z<n-1)return -1;

        for(int i=0;i<connections.length;i++){
            ds.findunion(connections[i][0],connections[i][1]);
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(ds.findParent(i));
        }

        return set.size()-1;
    }
}