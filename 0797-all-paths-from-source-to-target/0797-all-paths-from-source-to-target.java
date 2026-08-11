class Solution {
    class Pair{
        int node;
        List<Integer> list;
        public Pair(int node,List<Integer> list){
            this.list = new ArrayList<>(list);
            this.node = node;
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allpaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        bfs(graph,allpaths,path);
        return allpaths;
    }
    public void bfs(int arr[][],List<List<Integer>> allpaths, List<Integer> path){
        Queue<Pair> q = new LinkedList<>();
        path.add(0);
        q.add(new Pair(0,new ArrayList<>(path)));
        while(!q.isEmpty()){
            Pair p = q.remove();
            int node = p.node;
            List<Integer> curr = new ArrayList<>(p.list);
            if(node==arr.length-1){
                allpaths.add(new ArrayList<>(curr));
                continue;
            }
            for(int j:arr[node]){
                curr.add(j);
                q.add(new Pair(j,new ArrayList<>(curr)));
                curr.remove(curr.size()-1);
            }
        }
    }
}