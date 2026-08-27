class Solution {
    class Element implements Comparable<Element>{
        int src;int dest;
        int wt;
        public Element(int src,int dest,int wt){
            this.src = src;this.dest = dest;this.wt = wt;
        }

        public int compareTo(Element that){
            return Integer.compare(this.wt,that.wt);
        }
    }
    class DisjointSet{
        int parent[];
        public DisjointSet(int n){
            this.parent = new int[n];
            for(int i=0;i<this.parent.length;i++){
                this.parent[i]=i;
            }
        }

        public void findUnion(int u,int v){
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);

            if(ulp_u==ulp_v)return;
            parent[ulp_v]=ulp_u;
        }

        public int findParent(int node){
            if(parent[node]==node){
                return node;
            }

            return parent[node]=findParent(parent[node]);
        }
    }
    public int minCostConnectPoints(int[][] points) {
       boolean vis[] = new boolean[points.length];
       ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
       PriorityQueue<Element> pq = new PriorityQueue<>();
       DisjointSet ds = new DisjointSet(points.length);
       for(int i=0;i<points.length;i++){
        for(int j=i+1;j<points.length;j++){
            int wt = Math.abs(points[i][1]-points[j][1])+Math.abs(points[i][0]-points[j][0]);
            pq.add(new Element(i,j,wt));
        }
       }
        int ans=0;
       while(!pq.isEmpty()){
        Element e = pq.remove();
        int src = e.src;
        int dest = e.dest;
        int wt = e.wt;
        if(ds.findParent(src)==ds.findParent(dest))continue;
        else{
            ans = ans+wt;
            ds.findUnion(src,dest);
        }
       } 
       return ans;
    }
}