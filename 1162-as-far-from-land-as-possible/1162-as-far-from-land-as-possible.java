class Solution {
    class Element{
        int i;int j;int d;
        public Element(int i,int j,int d){
            this.i=i;
            this.j=j;
            this.d=d;
        }
    }
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        Queue<Element> q = new LinkedList<>();
        boolean flag = false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    q.add(new Element(i,j,0));
                    flag=true;
                    vis[i][j]=true;
                }
            }
        }
        if(!flag)return -1;

        bfs(q,vis,grid);
        int mindist = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                mindist = Math.max(mindist,grid[i][j]);
            }
        }
        return mindist==0?-1:mindist;
    }

    public void bfs(Queue<Element> q,boolean vis[][],int arr[][]){
        while(!q.isEmpty()){
            Element e = q.remove();
            int row = e.i;int col = e.j;int dist = e.d;

            arr[row][col] = dist;
            //up
            if(row-1>=0 && !vis[row-1][col]){
                vis[row-1][col]=true;
                q.add(new Element(row-1,col,dist+1));
            }
            //left
            if(col-1>=0 && !vis[row][col-1]){
                vis[row][col-1]=true;
                q.add(new Element(row,col-1,dist+1));
            }
            //right
            if(col+1<arr[0].length && !vis[row][col+1]){
                vis[row][col+1]=true;
                q.add(new Element(row,col+1,dist+1));
            }
            //down
            if(row+1<arr.length && !vis[row+1][col]){
                vis[row+1][col]=true;
                q.add(new Element(row+1,col,dist+1));
            }
        }
    }
}