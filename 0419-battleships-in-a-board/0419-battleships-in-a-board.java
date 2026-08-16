class Solution {
    public int countBattleships(char[][] board) {
        boolean vis[][] = new boolean[board.length][board[0].length];
        int cnt=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(!vis[i][j] && board[i][j]=='X'){
                    cnt++;
                    dfs(i,j,board,vis);
                }
            }
        }
        return cnt;
    }
    public void dfs(int i,int j,char arr[][],boolean vis[][]){
        vis[i][j]=true;
        if(i-1>=0 && !vis[i-1][j] && arr[i-1][j]=='X'){
            dfs(i-1,j,arr,vis);
        }
        if(j-1>=0 && !vis[i][j-1] && arr[i][j-1]=='X'){
            dfs(i,j-1,arr,vis);
        }
        if(i+1<arr.length && !vis[i+1][j] && arr[i+1][j]=='X'){
            dfs(i+1,j,arr,vis);
        }
        if(j+1<arr[0].length && !vis[i][j+1] && arr[i][j+1]=='X'){
            dfs(i,j+1,arr,vis);
        }
    }
}