class Solution {
    class Element{
        int i;
        int j;
        int dist;
        public Element(int i,int j,int dist){
            this.i=i;
            this.j=j;
            this.dist = dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean vis[][] = new boolean[grid.length][n];
        if(grid[0][0]==1 || grid[m-1][n-1]==1)return -1;
        return bfs(0,0,m,n,grid,vis);

    }

    public int bfs(int i,int j,int m,int n,int arr[][],boolean vis[][]){
        Queue<Element> q = new LinkedList<>();
        q.add(new Element(i,j,1));
        vis[i][j]=true;
        int distance = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Element e = q.remove();
            int row = e.i;
            int col = e.j;
            int dist = e.dist;
            if(row==m-1 && col==n-1){
                distance = Math.min(distance,dist);
            }
            if(row-1>=0 && !vis[row-1][col] && arr[row-1][col]==0){
                vis[row-1][col]=true;
                q.add(new Element(row-1,col,dist+1));
            }
            if(row+1<m && !vis[row+1][col] && arr[row+1][col]==0){
                vis[row+1][col]=true;
                q.add(new Element(row+1,col,dist+1));
            }
            if(col-1>=0 && !vis[row][col-1] && arr[row][col-1]==0){
                vis[row][col-1]=true;
                q.add(new Element(row,col-1,dist+1));
            }
            if(col+1<n && !vis[row][col+1] && arr[row][col+1]==0){
                vis[row][col+1]=true;
                q.add(new Element(row,col+1,dist+1));
            }
            if(row-1>=0 && col-1>=0 && !vis[row-1][col-1] && arr[row-1][col-1]==0){
                vis[row-1][col-1]=true;
                q.add(new Element(row-1,col-1,dist+1));
            }
            if(row-1>=0 && col+1<n && !vis[row-1][col+1] && arr[row-1][col+1]==0){
                vis[row-1][col+1]=true;
                q.add(new Element(row-1,col+1,dist+1));
            }
            if(row+1<m && col-1>=0 && !vis[row+1][col-1] && arr[row+1][col-1]==0){
                vis[row+1][col-1]=true;
                q.add(new Element(row+1,col-1,dist+1));
            }
            if(row+1<m && col+1<n && !vis[row+1][col+1] && arr[row+1][col+1]==0){
                vis[row+1][col+1]=true;
                q.add(new Element(row+1,col+1,dist+1));
            }
        }
        return distance==Integer.MAX_VALUE?-1:distance;
    }
}