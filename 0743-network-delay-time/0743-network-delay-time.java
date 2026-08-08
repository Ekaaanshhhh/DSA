class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int wt;
        public Pair(int p,int w){
            this.node = p;
            this.wt =w ;
        }
        public int compareTo(Pair that){
            return Integer.compare(this.wt,that.wt);
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        k=k-1;
        int time[] = new int[n];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[k]=0;
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]-1).add(new Pair(times[i][1]-1,times[i][2]));
        }

        dijkstra(adj,time,n,k);
        int min = time[0];
        for(int i=0;i<time.length;i++){
            if(time[i]==Integer.MAX_VALUE)return -1;
            min = Math.max(time[i],min);
        }
        return min;
    }
    public void dijkstra(List<List<Pair>> adj, int ans[],int n,int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.node;
            int time = p.wt;
            if(time>ans[node])continue;
            for(Pair j:adj.get(node)){
                int timetosend = j.wt+time;
                if(timetosend<ans[j.node]){
                    ans[j.node]=timetosend;
                    pq.add(new Pair(j.node,timetosend));
                }
            }
        }
    }
}