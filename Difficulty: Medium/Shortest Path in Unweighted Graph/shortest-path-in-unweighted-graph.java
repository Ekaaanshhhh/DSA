class Solution {
    class Pair{
        int val;int dist;
        public Pair(int val,int dist){
            this.val = val;
            this.dist = dist;
        }
    }
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean vis[] = new boolean[V];
        return bfs(vis,src,dest,adj);
    }
    public int bfs(boolean vis[],int src,int dest,ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,0));
        vis[src]=true;
        int distance = -1;
        while(!q.isEmpty()){
        Pair p = q.remove();
        int val = p.val;
        int dist = p.dist;
        if(val==dest){
            return dist;
        }
        for(int j:adj.get(val)){
            if(!vis[j]){
                vis[j]=true;
                q.add(new Pair(j,dist+1));
            }
        }
        }
        return -1;
    }
    
}