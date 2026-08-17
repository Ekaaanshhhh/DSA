class Solution {
    // class DisjointSet{
    //     ArrayList<Integer> rank = new ArrayList<>();
    //     ArrayList<Integer> parent = new ArrayList<>();
        
    //     public DisjointSet(int n){
    //         for(int i=0;i<=n;i++){
    //             rank.add(0);
    //             parent.add(i);
    //         }
    //     }
        
        
    //     public void findUnion(int u,int v){
    //         int ulp_u = findParent(u);
    //         int ulp_v = findParent(v);
    //         if(ulp_u==ulp_v)return;
            
    //         if(rank.get(ulp_u)<rank.get(ulp_v)){
    //             parent.set(ulp_u,ulp_v);
    //         }else if(rank.get(ulp_u)>rank.get(ulp_v)){
    //             parent.set(ulp_v,ulp_u);
    //         }
    //         else{
    //             parent.set(ulp_u,ulp_v);
    //             rank.set(ulp_v,rank.get(ulp_v)+1);
    //         }
    //     }
        
    //     public int findParent(int u){
    //         if(u==parent.get(u))return u;
            
    //         int ulp = findParent(parent.get(u));
    //         parent.set(u,ulp);
    //         return parent.get(u);
    //     }
    // }
    
    class DisjointSet{
        ArrayList<Integer> parent = new ArrayList<>();
        public DisjointSet(int n){
            for(int i=0;i<=n;i++){
                parent.add(i);
            }
        }
        
        public void findUnion(int u,int v){
            if(findParent(u)==findParent(v))return;
            
            parent.set(findParent(u),findParent(v));
        }
        
        public int findParent(int node){
            if(parent.get(node)==node)return node;
            
            int ulp = findParent(parent.get(node));
            parent.set(node,ulp);
            return parent.get(node);
        }
    }
    public ArrayList<Integer> DSU(int n, int[][] queries) {
        // code here
        DisjointSet ds = new DisjointSet(n);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            if(queries[i][0]==1){
                ds.findUnion(queries[i][1],queries[i][2]);
            }else{
                ans.add(ds.findParent(queries[i][1]));
            }
        }
        return ans;
    }
}
