class Solution {
    class Pair{
        int node;
        long height;
        public Pair(int node,long height){
            this.node = node;
            this.height = height;
        }
    }
    public long weightedSum(int[] parent, int[] nums) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<parent.length;i++){
            if(parent[i]!=-1)
            adj.get(parent[i]).add(i);
        }


        long h = bfs(adj);
        long ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,1));
        while(!q.isEmpty()){
            Pair e = q.remove();
            int node = e.node;
            long depth = e.height;
            ans = ans+(nums[node]*(h-depth+1));
            for(int j:adj.get(node)){
                q.add(new Pair(j,depth+1));
            }
        }
        return ans;
    }
    public long bfs(ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,1));
        long height = 1L;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int node = p.node;
            long h = p.height;
            height = Math.max(height,h);
            for(int j:adj.get(node)){
                q.add(new Pair(j,h+1L));
            }
        }
        return height;
    }
}