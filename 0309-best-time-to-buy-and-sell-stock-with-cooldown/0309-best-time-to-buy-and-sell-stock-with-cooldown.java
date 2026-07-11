class Solution {
    public int helper(int i,int prices[],int buy,int dp[][]){
        if(i>=prices.length)return 0;
        if(dp[i][buy]!=-1)return dp[i][buy];
        if(buy==1){
            return dp[i][buy]=Math.max(-prices[i]+helper(i+1,prices,0,dp),helper(i+1,prices,1,dp));
        }else{
            return dp[i][buy]=Math.max(prices[i]+helper(i+2,prices,1,dp),helper(i+1,prices,0,dp));
        }
    }
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,prices,1,dp);
    }
}