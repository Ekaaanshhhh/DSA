class Solution {
    public boolean checkCycle(boolean vis[],boolean pathVis[],List<List<Integer>> adj,int i){
        vis[i]=true;
        pathVis[i]=true;

        for(int j:adj.get(i)){
            if(!vis[j]){
                if(checkCycle(vis,pathVis,adj,j))return true;
            }
            else if(pathVis[j])return true;
        }
        pathVis[i]=false;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] arr) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][1]).add(arr[i][0]);
        }
        int ans[] = new int[numCourses];
        boolean vis[] = new boolean[numCourses];
        boolean pathVis[] = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(checkCycle(vis,pathVis,adj,i))return new int[0];
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[numCourses];
        for(int i=0;i<arr.length;i++){
            indegree[arr[i][0]]++;
        }

        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)q.add(i);
        }

        bfs(q,indegree,adj,ans);
        return ans;
    }
    public void bfs(Queue<Integer> q,int indegree[],List<List<Integer>> adj,int ans[]){
        int index=0;
        while(!q.isEmpty()){
            int top = q.remove();
            ans[index++]=top;
            for(int j:adj.get(top)){
                indegree[j]--;
                if(indegree[j]==0)q.add(j);
            }
        }
    }
}