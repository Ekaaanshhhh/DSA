class Solution {
    class Pair{
        int node;
        int time;
        public Pair(int node,int time){
            this.node = node;
            this.time = time;
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<manager.length;i++){
            if(manager[i]!=-1)
            adj.get(manager[i]).add(i);
        }

        Queue<Pair> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        q.add(new Pair(headID,0));
        int time[] = new int[n];
        vis[headID] = true;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int node = p.node;
            int t = p.time;
            for(int j:adj.get(node)){
                if(!vis[j]){
                    vis[j]=true;
                    q.add(new Pair(j,t+informTime[node]));
                    time[j]=t+informTime[node];
                }
            }
        }
        int ans = 0;
        for(int i=0;i<time.length;i++){
            ans = Math.max(ans,time[i]);
        }

        return ans;
    }
}