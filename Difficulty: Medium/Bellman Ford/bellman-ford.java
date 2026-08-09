class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
        // code here
        ArrayList<Integer> dist = new ArrayList<>();
        for(int i=0;i<V;i++)dist.add(100000000);
        dist.set(src,0);
        for(int i=1;i<=V-1;i++){
            for(int j=0;j<edges.length;j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                if(dist.get(u)==100000000)continue;
                if(dist.get(u)+wt<dist.get(v)){
                    dist.set(v,dist.get(u)+wt);
                }
            }
        }
        for(int j=0;j<edges.length;j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                if(dist.get(u)==100000000)continue;
                if(dist.get(u)+wt<dist.get(v)){
                     ArrayList<Integer> ans = new ArrayList<>();
                     ans.add(-1);
                     return ans;
                }
            }
        return dist;
    }
}
