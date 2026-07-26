class Solution {
    class Pair{
        int i;
        int j;
        public Pair(int x,int y){
            i=x;j=y;
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean vis[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(!vis[i][j] && board[i][j]=='O'){
                        bfs(board,i,j,m,n,vis);
                    }
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O')board[i][j]='X';
                else if(board[i][j]=='-')board[i][j]='O';
            }
        }
    }

    public void bfs(char arr[][],int i,int j,int m,int n,boolean vis[][]){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        vis[i][j]=true;
        arr[i][j]='-';
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.i;
            int col = p.j;
            //up
            if(row-1>=0 && !vis[row-1][col] && arr[row-1][col]=='O'){
                arr[row-1][col]='-';
                q.add(new Pair(row-1,col));
                vis[row-1][col]=true;
            }
            //down
            if(row+1<m-1 && !vis[row+1][col] && arr[row+1][col]=='O'){
                arr[row+1][col]='-';
                q.add(new Pair(row+1,col));
                vis[row+1][col]=true;
            }
            //left
            if(col-1>=0 && !vis[row][col-1] && arr[row][col-1]=='O'){
                arr[row][col-1]='-';
                q.add(new Pair(row,col-1));
                vis[row][col-1]=true;
            }
            //right
            if(col+1<n-1 && !vis[row][col+1] && arr[row][col+1]=='O'){
                arr[row][col+1]='-';
                q.add(new Pair(row,col+1));
                vis[row][col+1]=true;
            }
        }
    }
}