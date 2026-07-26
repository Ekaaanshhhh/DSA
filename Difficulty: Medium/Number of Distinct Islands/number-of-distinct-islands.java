class Solution {
    public int countDistinctIslands(char[][] grid) {
        // code here
        int m = grid.length;
        int n = grid[0].length;
        
        boolean vis[][] = new boolean[m][n];
        HashSet<ArrayList<ArrayList<Integer>>> set = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]=='L'){
                    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
                    dfs(grid,i,j,m,n,vis,list,i,j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    
    public void dfs(char arr[][],int i,int j,int m,int n,boolean vis[][],ArrayList<ArrayList<Integer>> list,int baserow,int basecol){
        vis[i][j]=true;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(baserow-i);ans.add(basecol-j);
        list.add(new ArrayList<>(ans));
        if(i-1>=0 && !vis[i-1][j] && arr[i-1][j]=='L'){
            dfs(arr,i-1,j,m,n,vis,list,baserow,basecol);
        }
        if(i+1<m && !vis[i+1][j] && arr[i+1][j]=='L'){
            dfs(arr,i+1,j,m,n,vis,list,baserow,basecol);
        }
        if(j-1>=0 && !vis[i][j-1] && arr[i][j-1]=='L'){
            dfs(arr,i,j-1,m,n,vis,list,baserow,basecol);
        }
        if(j+1<n && !vis[i][j+1] && arr[i][j+1]=='L'){
            dfs(arr,i,j+1,m,n,vis,list,baserow,basecol);
        }
    }
}