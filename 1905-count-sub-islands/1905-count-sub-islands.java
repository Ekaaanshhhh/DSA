class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean vis[][] = new boolean[grid2.length][grid2[0].length];
        ArrayList<Pair> list = new ArrayList<>();
        int cnt=0;

        for(int i=0;i<vis.length;i++){
            for(int j=0;j<vis[0].length;j++){
                if(grid2[i][j]==1 && !vis[i][j] && grid1[i][j]==1){
                    dfs(grid1,grid2,i,j,vis.length,vis[0].length,vis,list);
                    boolean found = false;
                    for(Pair x:list){
                        if(grid1[x.row][x.col]==0){
                            found=true;
                            break;
                        }
                    }
                    if(!found)cnt++;
                    list.clear();
                }
            }
        }
        return cnt;
    }
    public void dfs(int arr1[][],int arr2[][],int i,int j,int m,int n,boolean vis[][],ArrayList<Pair> list){
        vis[i][j]=true;
        list.add(new Pair(i,j));
        if(i-1>=0 && arr2[i-1][j]==1 && !vis[i-1][j]){
            dfs(arr1,arr2,i-1,j,m,n,vis,list);
        }if(j-1>=0 && arr2[i][j-1]==1 && !vis[i][j-1]){
            dfs(arr1,arr2,i,j-1,m,n,vis,list);
        }
        if(i+1<m && arr2[i+1][j]==1 && !vis[i+1][j]){
            dfs(arr1,arr2,i+1,j,m,n,vis,list);
        }
        if(j+1<n && arr2[i][j+1]==1 && !vis[i][j+1]){
           dfs(arr1,arr2,i,j+1,m,n,vis,list);
        }
    }
}