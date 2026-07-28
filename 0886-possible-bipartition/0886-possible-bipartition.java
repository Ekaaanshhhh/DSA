class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<dislikes.length;i++){
            list.get(dislikes[i][0]-1).add(dislikes[i][1]-1);
            list.get(dislikes[i][1]-1).add(dislikes[i][0]-1);
        }

        int vis[] = new int[n];
        Arrays.fill(vis,-1);

        for(int i=0;i<vis.length;i++){
            if(vis[i]==-1){
                if(dfs(i,0,list,vis))return false;
            }
        }
        return true;
    }

    public boolean dfs(int i,int c,List<List<Integer>> adj,int vis[]){
        vis[i]=c;

        for(int j:adj.get(i)){
            if(vis[j]==-1){
                if(dfs(j,vis[i]==0?1:0,adj,vis))return true;
            }else if(vis[j]!=-1 && vis[j]==vis[i])return true;
        }

        return false;
    }
}