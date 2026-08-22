class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row = row;
            this.col =col;
        }
    }
    public int islandPerimeter(int[][] grid) {
        int peri=0;
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    peri = bfs(i,j,grid,vis);
                }
            }
        }
        return peri;
    }
    public int bfs(int i,int j,int arr[][],boolean vis[][]){
        Queue<Pair> q = new LinkedList<>();
        int m = arr.length;int n = arr[0].length;
        int peri=0;
        vis[i][j]=true;
        q.add(new Pair(i,j));
        while(!q.isEmpty()){
            Pair p = q.remove();
            int directions = 0;
            int row = p.row;
            int col =p.col;
            if(row-1>=0 && arr[row-1][col]==1){
                directions++;
                if(!vis[row-1][col]){
                    vis[row-1][col]=true;
                    q.add(new Pair(row-1,col));
                }
            }
            if(row+1<m && arr[row+1][col]==1){
                directions++;
                if(!vis[row+1][col]){
                    vis[row+1][col]=true;
                    q.add(new Pair(row+1,col));
                }
            }
            if(col-1>=0 && arr[row][col-1]==1){
                directions++;
                if(!vis[row][col-1]){
                    vis[row][col-1]=true;
                    q.add(new Pair(row,col-1));
                }
            }
            if(col+1<n && arr[row][col+1]==1){
                directions++;
                if(!vis[row][col+1]){
                    vis[row][col+1]=true;
                    q.add(new Pair(row,col+1));
                }
            }
            peri+=4-directions;
        }
        return peri;
    }
}