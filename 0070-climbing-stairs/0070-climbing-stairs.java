class Solution {
    public int helper(int i,int dp[]){
        if(i==0){
            return 1;
        }
        if(dp[i]!=-1)return dp[i];
        int one_step = helper(i-1,dp);
        int two_step = 0;
        if(i>1){
            two_step = helper(i-2,dp);
        }

        return dp[i]=one_step+two_step;
    }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
}