class Solution {
    class Pair{
        int row;int col;
        public Pair(int r,int c){
            row = r;
            col = c;
        }
    }
    public void gameOfLife(int[][] board) {
        HashSet<Pair> convert = new HashSet<>(); 
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==1){
                    int n= liveneighbour(i,j,board);
                    if(n<2)convert.add(new Pair(i,j));
                    else if(n>=2 && n<=3)continue;
                    else if(n>3)convert.add(new Pair(i,j));
                }else{
                    int n = liveneighbour(i,j,board);
                    if(n==3)convert.add(new Pair(i,j));
                }
            }
        }
        for(Pair p:convert){
            int row = p.row;
            int col = p.col;
            board[row][col]=board[row][col]==0?1:0;
        }
        
    }
    public int liveneighbour(int i,int j,int arr[][]){
        int cnt=0;
        if(i+1<arr.length && (arr[i+1][j]==1 || arr[i+1][j]==-1))cnt++;
        if(j+1<arr[0].length && (arr[i][j+1]==1 || arr[i][j+1]==-1))cnt++;
        if(i-1>=0 && (arr[i-1][j]==1 || arr[i-1][j]==-1))cnt++;
        if(j-1>=0 && (arr[i][j-1]==1|| arr[i][j-1]==-1))cnt++;
        if(i+1<arr.length && j+1<arr[0].length && (arr[i+1][j+1]==1 || arr[i+1][j+1]==-1))cnt++;
        if(i+1<arr.length && j-1>=0 && (arr[i+1][j-1]==1 || arr[i+1][j-1]==-1))cnt++;
        if(i-1>=0 && j+1<arr[0].length && (arr[i-1][j+1]==1|| arr[i-1][j+1]==-1))cnt++;
        if(i-1>=0 && j-1>=0 && (arr[i-1][j-1]==1||arr[i-1][j-1]==-1))cnt++;

        return cnt;
    }
}