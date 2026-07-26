class Solution {
    class Pair{
        int i;int j;
        public Pair(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    public int numEnclaves(int[][] grid) {
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        int m = grid.length;
        int n = grid[0].length;

        int cnt = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i==m-1 || j==n-1)){
                    if(grid[i][j]==1 && !vis[i][j])
                    bfs(grid,i,j,m,n,vis);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    if(!vis[i][j])cnt++;
                }
            }
        }
        return cnt;
    }

    public void bfs(int arr[][],int i,int j,int m,int n,boolean vis[][]){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        vis[i][j]=true;


        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.i;
            int col = p.j;

            //up
            if(row-1>=0 && !vis[row-1][col] && arr[row-1][col]==1){
                vis[row-1][col]=true;
                q.add(new Pair(row-1,col));
            }
            //down
            if(row+1<m && !vis[row+1][col] && arr[row+1][col]==1){
                vis[row+1][col]=true;
                q.add(new Pair(row+1,col));
            }
            //left
            if(col-1>=0 && !vis[row][col-1] && arr[row][col-1]==1){
                vis[row][col-1]=true;
                q.add(new Pair(row,col-1));
            }
            //right
            if(col+1<n && !vis[row][col+1] && arr[row][col+1]==1){
                vis[row][col+1]=true;
                q.add(new Pair(row,col+1));
            }
        }
    }
}