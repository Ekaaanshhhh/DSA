class Solution {
    public int helper(int i,int j,int dp[][]){
        if(i==0 && j==0){
            return 1;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        int go_left = 0;
        if(i>0){
            go_left=helper(i-1,j,dp);
        }
        int go_right = 0;
        if(j>0){
            go_right = helper(i,j-1,dp);
        }

        dp[i][j] =  go_left+go_right;

        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(m-1,n-1,dp);

        // dp[0][0]=1;
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(i==0 && j==0)continue;
        //         int go_up = 0;
        //         int go_left = 0;
        //         if(i>0){
        //             go_up = dp[i-1][j];
        //         }
        //         if(j>0){
        //             go_left = dp[i][j-1];
        //         }
        //         dp[i][j] = go_up+go_left;
        //     }
        // }
        // return dp[m-1][n-1];
        
    }
}