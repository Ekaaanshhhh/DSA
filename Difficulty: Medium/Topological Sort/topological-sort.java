class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        
        Stack<Integer> stack = new Stack<>();
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,adj,vis,stack);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        
        return ans;
        
    }
    public void dfs(int i,ArrayList<ArrayList<Integer>> adj,boolean vis[],Stack<Integer> stack){
        vis[i]=true;
        for(int j:adj.get(i)){
            if(!vis[j]){
                dfs(j,adj,vis,stack);
            }
        }
        stack.push(i);
    }
}