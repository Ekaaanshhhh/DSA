class Solution {
    public ArrayList<Integer> numOfIslands(int n, int m, int[][] operators) {
        // Your code here
        int arr[][] = new int[n][m];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<operators.length;i++){
            arr[operators[i][0]][operators[i][1]]=1;
            ans.add(count_island(arr));
        }
        return ans;
    }
    public int count_island(int arr[][]){
        boolean vis[][] = new boolean[arr.length][arr[0].length];
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(!vis[i][j] && arr[i][j]==1){
                    cnt++;
                    dfs(arr,i,j,vis);
                }
            }
        }
        return cnt;
    }
    public void dfs(int arr[][],int i,int j,boolean vis[][]){
        vis[i][j]=true;
        if(i-1>=0 && arr[i-1][j]==1 && !vis[i-1][j]){
            dfs(arr,i-1,j,vis);
        }
        if(j-1>=0 && arr[i][j-1]==1 && !vis[i][j-1]){
            dfs(arr,i,j-1,vis);
        }
        if(i+1<arr.length && arr[i+1][j]==1 && !vis[i+1][j]){
            dfs(arr,i+1,j,vis);
        }
        if(j+1<arr[0].length && arr[i][j+1]==1 && !vis[i][j+1]){
            dfs(arr,i,j+1,vis);
        }
    }
}