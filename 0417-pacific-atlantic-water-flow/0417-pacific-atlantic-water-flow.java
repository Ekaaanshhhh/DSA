class Solution {
    class Element{
        int row;
        int col;
        public Element(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(bfs(i,j,heights)){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    public boolean bfs(int i,int j,int arr[][]){
        Queue<Element> q = new LinkedList<>();
        boolean a = false;
        boolean p = false;
        boolean vis[][] = new boolean[arr.length][arr[0].length];
        vis[i][j]=true;
        q.add(new Element(i,j));
        while(!q.isEmpty()){
            Element e = q.remove();
            int row = e.row;
            int col = e.col;
            if(row==arr.length-1 || col==arr[0].length-1)a=true;
            if(row==0 || col==0)p=true;
            if(a&&p)return true;
            if(row-1>=0 && arr[row][col]>=arr[row-1][col] && !vis[row-1][col]){
                vis[row-1][col]=true;
                q.add(new Element(row-1,col));
            }
            if(col-1>=0 && arr[row][col]>=arr[row][col-1] && !vis[row][col-1]){
                vis[row][col-1]=true;
                q.add(new Element(row,col-1));
            }
            if(row+1<arr.length && arr[row][col]>=arr[row+1][col] && !vis[row+1][col]){
                vis[row+1][col]=true;
                q.add(new Element(row+1,col));
            }
            if(col+1<arr[0].length && arr[row][col]>=arr[row][col+1] && !vis[row][col+1]){
                vis[row][col+1]=true;
                q.add(new Element(row,col+1));
            }
        }
        return false;
    }
}