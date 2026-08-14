class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,list,vis,adj);
                ans.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return ans;
    }
    public void dfs(int i, ArrayList<Integer> list,boolean vis[], ArrayList<ArrayList<Integer>> adj){
        vis[i]=true;
        list.add(i);
        for(int j:adj.get(i)){
            if(!vis[j]){
                dfs(j,list,vis,adj);
            }
        }
    }
}