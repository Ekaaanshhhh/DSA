class Solution {
    class Node{
        int val;
        int wt;
        public Node(int v,int w){
            this.val = v;
            this.wt  = w;
        }
    }
    class Element implements Comparable<Element>{
        int val;
        int wt;
        public Element(int val,int wt){
            this.val = val;
            this.wt = wt;
        }
        public int compareTo(Element that){
            return Integer.compare(this.wt,that.wt);
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Node>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new Node(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Node(edges[i][0],edges[i][2]));
        }
        int cnt=Integer.MAX_VALUE;
        int x=0;
        for(int i=0;i<n;i++){
            int cities_reached = shortest_path(i,adj,distanceThreshold,n);
            System.out.println(cities_reached);
            if(cities_reached<cnt){
                cnt = cities_reached;
                x = i;
            }else if(cities_reached==cnt){
                x = Math.max(x,i);
            }
        }
        return x;
    }
    public int shortest_path(int i, List<List<Node>> adj,int k,int n){
        int ans[] = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[i]=0;
        PriorityQueue<Element> pq = new PriorityQueue<>();
        pq.add(new Element(i,0));
        while(!pq.isEmpty()){
            Element e = pq.remove();
            int val = e.val;
            int weight = e.wt;
            if(weight>ans[val])continue;
            for(Node j:adj.get(val)){
                int weighttogo = j.wt+weight;
                if(weighttogo<ans[j.val]){
                    ans[j.val]=weighttogo;
                    pq.add(new Element(j.val,weighttogo));
                }
            }
        }
        int cnt=0;
        for(int j=0;j<n;j++){
            if(ans[j]>0 && ans[j]<=k)cnt++;
        }
        return cnt;
    }
}