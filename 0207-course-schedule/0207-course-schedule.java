class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        boolean vis[] = new boolean[numCourses];
        boolean pathVis[] = new boolean[numCourses];

        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                if(dfs(i,vis,pathVis,adj))return false;
            }
        }
        return true;
    }

    public boolean dfs(int i,boolean vis[],boolean pathVis[],List<List<Integer>> adj){
        vis[i]=true;
        pathVis[i]=true;

        for(int j:adj.get(i)){
            if(!vis[j]){
                if(dfs(j,vis,pathVis,adj))return true;
            }
            else if(pathVis[j]==true)return true;
        }
        pathVis[i]=false;
        return false;
    }
}