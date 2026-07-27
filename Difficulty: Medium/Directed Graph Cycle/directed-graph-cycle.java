class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(i,vis,pathVis,adj))return true;
            }
        }
        return false;
    }
    public boolean dfs(int i,boolean vis[],boolean pathVis[],ArrayList<ArrayList<Integer>> adj){
        vis[i]=true;
        pathVis[i]=true;
        
        for(int j:adj.get(i)){
            if(!vis[j]){
                if(dfs(j,vis,pathVis,adj))return true;
            }
            else if(pathVis[j])return true;
        }
        
        pathVis[i]=false;
        return false;
    }
}