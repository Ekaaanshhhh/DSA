class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[] = new boolean[rooms.size()];

        dfs(0,rooms,vis);
        for(int i=0;i<vis.length;i++){
            System.out.println(vis[i]);
        }
        for(int i=0;i<vis.length;i++){
            if(!vis[i])return false;
        }

        return true;
    }
    public void dfs(int i,List<List<Integer>> adj,boolean vis[]){
        vis[i]=true;

        for(int j:adj.get(i)){
            if(j!=i && !vis[j]){
                dfs(j,adj,vis);
            }
        }
    }
}