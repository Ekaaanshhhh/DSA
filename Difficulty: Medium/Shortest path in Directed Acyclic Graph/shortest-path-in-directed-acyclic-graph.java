class Solution {
    class Pair{
        int n;
        int w;
        Pair(int n,int w){
            this.n = n;
            this.w = w;
        }
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        int ans[] = new int[V];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0]=0;
        Stack<Integer> stack = new Stack<>();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        }
        
        int top_sort[] = new int[V];
        boolean vis[] = new boolean[V];
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                dfs(i,adj,vis,stack);
            }
        }
        shortestDist(ans,stack,adj);
        for(int i=0;i<ans.length;i++){
            if(ans[i]==Integer.MAX_VALUE)ans[i]=-1;
        }
        return ans;
    }
    public void shortestDist(int ans[],Stack<Integer> stack,ArrayList<ArrayList<Pair>> adj){
        while(!stack.isEmpty()){
            int first = stack.pop();
            int weight = ans[first];
            if(weight!=Integer.MAX_VALUE){
            for(Pair j:adj.get(first)){
                int n = j.n;
                int w = j.w;
                ans[n] = Math.min(weight+w,ans[n]);
            }
            }
        }
    }
    public void dfs(int i,ArrayList<ArrayList<Pair>> adj,boolean vis[],Stack<Integer> stack){
        vis[i]=true;
        for(Pair j:adj.get(i)){
            int neighbour = j.n;
            if(!vis[neighbour]){
                dfs(neighbour,adj,vis,stack);
            }
        }
        stack.push(i);
    }
}