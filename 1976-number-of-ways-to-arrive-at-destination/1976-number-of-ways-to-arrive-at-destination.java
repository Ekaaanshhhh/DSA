class Solution {
    static int MOD = 1000000007;
     class Pair implements Comparable<Pair>{
        int node;
        long wt;
        public Pair(int p,long w){
            this.node = p;
            this.wt =w ;
        }
        public int compareTo(Pair that){
            if(this.wt!=that.wt){
            return Long.compare(this.wt,that.wt);}

            return Integer.compare(this.node,that.node);
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        long time[] = new long[n];
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }

        Arrays.fill(time,Long.MAX_VALUE);
        time[0]=0;
        int ways[] = new int[n];
        ways[0]=1;
        dijkstra(adj,time,ways);
        return ways[n-1];
    }
    public void dijkstra( List<List<Pair>> adj,long time[],int ways[]){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.node;
            long dist = p.wt;
            if(dist>time[node])continue;
            for(Pair j:adj.get(node)){
                long timetosend = j.wt+dist;
                if(timetosend<time[j.node]){
                    time[j.node]=timetosend;
                    ways[j.node]=ways[node]%MOD;
                    pq.add(new Pair(j.node,timetosend));
                }
                else if(timetosend==time[j.node]){
                    ways[j.node] = (ways[j.node]+ways[node])%MOD;
                }
            }
        }
    }
}