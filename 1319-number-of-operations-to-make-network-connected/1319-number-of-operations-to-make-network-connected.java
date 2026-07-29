class Solution {
    public int makeConnected(int n, int[][] connections) {
        int z=connections.length;
        if(z<n-1)return -1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<connections.length;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        boolean vis[] = new boolean[n];
        int cnt=0;
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                cnt++;
                dfs(i,adj,vis);
            }
        }
       return cnt-1;
    }
    public void dfs(int i,List<List<Integer>> adj,boolean vis[]){
        vis[i]=true;
        for(int j:adj.get(i)){
            if(!vis[j]){
                dfs(j,adj,vis);
            }
        }
    }
}