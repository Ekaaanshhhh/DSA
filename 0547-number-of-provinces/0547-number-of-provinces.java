class Solution {
    public void dfs(List<List<Integer>> adj, int i, boolean vis[]){
        vis[i]=true;
        for(int j=0;j<adj.get(i).size();j++){
            if(!vis[adj.get(i).get(j)]){
                vis[adj.get(i).get(j)]=true;
                dfs(adj,adj.get(i).get(j),vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }

        int cnt = 0;
        boolean vis[] = new boolean[isConnected.length];
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                cnt++;
                dfs(adj,i,vis);
            }
        }

        return cnt;
    }
}