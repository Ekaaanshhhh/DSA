class Solution {
    public boolean dfs(int i,int c,ArrayList<ArrayList<Integer>> list,int vis[]){
        vis[i]=c;
        for(int j:list.get(i)){
            if(vis[j]==-1){
                vis[j]=c==0?1:0;
                if(!dfs(j,vis[j],list,vis))return false;
            }else if(vis[i]==vis[j])return false;
        }
        return true;
    }
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<V;i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        
        int vis[] = new int[V];
        Arrays.fill(vis,-1);
        
        for(int i=0;i<V;i++){
            if(vis[i]==-1){
                if(!dfs(i,0,list,vis))return false;
            }
        }
        return true;
    }
}