class Solution {
    class Pair{
        int child;
        int parent;
        public Pair(int c,int p){
            child = c;
            parent=p;
        }
    }
    // public boolean bfs(ArrayList<ArrayList<Integer>> adj,int i,boolean vis[]){
    //     Queue<Pair> q = new LinkedList<>();
    //     q.add(new Pair(i,-1));
    //     vis[i]=true;
    //     while(!q.isEmpty()){
    //         Pair p = q.remove();
    //         int node = p.child;
    //         for(int j:adj.get(node)){
    //             if(!vis[j]){
    //                 vis[j]=true;
    //                 q.add(new Pair(j,node));
    //             }
    //             else if(j!=p.parent && vis[j])return true;
    //         }
    //     }
    //     return false;
    // }
    
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int i,int parent,boolean vis[]){
        vis[i]=true;
        for(int j:adj.get(i)){
            if(!vis[j]){
                if(dfs(adj,j,i,vis)==true)return true;
            }else if(j!=parent && vis[j]){
                return true;
            }
        }
        return false;
        
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean vis[] = new boolean[V];
        Arrays.fill(vis,false);
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                if(dfs(adj,i,-1,vis))return true;
            }
        }
        return false;
    }
}