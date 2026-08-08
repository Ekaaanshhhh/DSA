class Solution {
    class Element implements Comparable<Element>{
        int stops;
        int node;
        int distance;
        public Element(int s,int n,int d){
            stops = s;
            node = n;
            distance = d;
        }

        public int compareTo(Element that){
            if(that.stops!=this.stops){
                return Integer.compare(this.stops,that.stops);
            }
            return Integer.compare(this.node,that.node);
        }
    }
    class Pair{
        int val;
        int wt;
        public Pair(int val,int wt){
            this.val = val;
            this.wt = wt;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        int stops[] = new int[n];
        Arrays.fill(stops,Integer.MAX_VALUE);
        stops[src]=-1;

        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        return dijkstra(adj,k,src,dst,dist,stops);
    }
    public int dijkstra(List<List<Pair>> adj,int k,int src,int dest,int dist[],int stations[]){
        PriorityQueue<Element> pq = new PriorityQueue<>();
        pq.add(new Element(-1,src,0));
        while(!pq.isEmpty()){
            Element e = pq.remove();
            int node = e.node;
            int stops = e.stops;
            int distance = e.distance;
            if(stops>=k)continue;
            for(Pair j:adj.get(node)){
                int disttogo = j.wt+distance;
                if(disttogo<dist[j.val]){
                        stations[j.val]=stops+1;
                        dist[j.val]=disttogo;
                        pq.add(new Element(stops+1,j.val,disttogo));
                }
            }
        }
        if(stations[dest]>k)return -1;
        if(dist[dest]==Integer.MAX_VALUE)return -1;
        return dist[dest];
    }
}