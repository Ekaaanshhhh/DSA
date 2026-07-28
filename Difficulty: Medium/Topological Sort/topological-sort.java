class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        boolean vis[] = new boolean[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        Stack<Integer> ans = new Stack<>();
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,adj,ans,vis);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(!ans.isEmpty()){
            list.add(ans.pop());
        }
        
        return list;
    }
    public void dfs(int i,ArrayList<ArrayList<Integer>> adj,Stack<Integer> ans,boolean vis[]){
        vis[i]=true;
        
        for(int j:adj.get(i)){
            if(!vis[j]){
                dfs(j,adj,ans,vis);
            }
        }
        
        ans.push(i);
    }
}