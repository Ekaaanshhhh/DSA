class Solution {
    class Element{
        int row;
        int col;
        public Element(int r,int c){
            row = r;
            col = c;
        }
    }
    public int numIslands(char[][] grid) {
        int count=0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        Queue<Element> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='0')continue;
                if(!visited[i][j]){
                    q.add(new Element(i,j));
                    visited[i][j]=true;
                    bfs(i,j,q,visited,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int i,int j,Queue<Element> q,boolean visited[][],char grid[][]){
        while(!q.isEmpty()){
            Element e = q.remove();
            int row = e.row;
            int col = e.col;
            //up
            if(row-1>=0 && !visited[row-1][col] && grid[row-1][col]!='0'){
                q.add(new Element(row-1,col));
                visited[row-1][col] = true;
            }
            //down
            if(row+1<grid.length && !visited[row+1][col]&&grid[row+1][col]!='0'){
                q.add(new Element(row+1,col));
                visited[row+1][col]=true;
            }
            //left
            if(col-1>=0 && !visited[row][col-1] && grid[row][col-1]!='0'){
                q.add(new Element(row,col-1));
                visited[row][col-1]=true;
            }
            //right
            if(col+1<grid[0].length && !visited[row][col+1]&&grid[row][col+1]!='0'){
                q.add(new Element(row,col+1));
                visited[row][col+1]=true;
            }
        }
    }
}