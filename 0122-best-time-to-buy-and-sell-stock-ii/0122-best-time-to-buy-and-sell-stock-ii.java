class Solution {
    // public int helper(int i,int buy,int prices[],int dp[][]){
    //     if(i==prices.length){
    //         return 0;
    //     }
    //     if(dp[i][buy]!=-1)return dp[i][buy];
    //     if(buy==1){
    //         return dp[i][buy]=Math.max(-prices[i]+helper(i+1,0,prices,dp),0+helper(i+1,1,prices,dp));
    //     }
    //     else{
    //         return dp[i][buy]=Math.max(prices[i]+helper(i+1,1,prices,dp),0+helper(i+1,0,prices,dp));
    //     }
    // }
    public int maxProfit(int[] prices) {
        // int dp[][] = new int[prices.length][2];
        // for(int i=0;i<dp.length;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return helper(0,1,prices,dp);
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][1] = Math.max(-prices[i] + dp[i + 1][0],dp[i + 1][1]);
            dp[i][0] = Math.max(prices[i] + dp[i + 1][1],dp[i + 1][0]);
        }
        return dp[0][1];    
    }
}