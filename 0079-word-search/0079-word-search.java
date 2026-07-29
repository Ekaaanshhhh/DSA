class Solution {
    public boolean exist(char[][] board, String word) {
        boolean vis[][] = new boolean[board.length][board[0].length];


        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(i,j,1,board,vis,word))return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int i,int j,int index,char arr[][],boolean vis[][],String word){
        vis[i][j]=true;
        if(index==word.length())return true;
        if(i-1>=0 && !vis[i-1][j] && arr[i-1][j]==word.charAt(index)){
            vis[i-1][j]=true;
            if(dfs(i-1,j,index+1,arr,vis,word))return true;
        }
        if(j-1>=0 && !vis[i][j-1] && arr[i][j-1]==word.charAt(index)){
            vis[i][j-1]=true;
            if(dfs(i,j-1,index+1,arr,vis,word))return true;
        }
        if(i+1<arr.length && !vis[i+1][j] && arr[i+1][j]==word.charAt(index)){
            vis[i+1][j]=true;
            if(dfs(i+1,j,index+1,arr,vis,word))return true;
        }
        if(j+1<arr[0].length && !vis[i][j+1] && arr[i][j+1]==word.charAt(index)){
            vis[i][j+1]=true;
            if(dfs(i,j+1,index+1,arr,vis,word))return true;
        }
        vis[i][j]=false;
        return false;
    }
}