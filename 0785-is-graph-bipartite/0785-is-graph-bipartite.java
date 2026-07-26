class Solution {
    public boolean isBipartite(int[][] graph) {
        int vis[] = new int[graph.length];
        Arrays.fill(vis,-1);
        for(int i=0;i<vis.length;i++){
            if(vis[i]==-1)
            if(!bfs(i,graph,vis))return false;
        }
        return true;
    }
    public boolean bfs(int i,int graph[][],int vis[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i]=0;
        while(!q.isEmpty()){
            int node = q.remove();
            for(int j:graph[node]){
                if(vis[j]==-1){
                    vis[j]=vis[node]==0?1:0;
                    q.add(j);
                }
                else if(vis[j]==vis[node])return false;
            }
        }
        return true;
    }
}