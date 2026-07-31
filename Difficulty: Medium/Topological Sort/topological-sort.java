class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        int indegree[] = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            indegree[edges[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        bfs(q,indegree,adj,ans);
        return ans;
    }
    // public void dfs(int i,ArrayList<ArrayList<Integer>> adj,Stack<Integer> ans,boolean vis[]){
    //     vis[i]=true;
        
    //     for(int j:adj.get(i)){
    //         if(!vis[j]){
    //             dfs(j,adj,ans,vis);
    //         }
    //     }
        
    //     ans.push(i);
    // }
    
    public void bfs(Queue<Integer> q,int indegree[],ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans){
        while(!q.isEmpty()){
            int top = q.remove();
            ans.add(top);
            for(int j:adj.get(top)){
                indegree[j]--;
                if(indegree[j]==0)
                q.add(j);
            }
        }
    }
}