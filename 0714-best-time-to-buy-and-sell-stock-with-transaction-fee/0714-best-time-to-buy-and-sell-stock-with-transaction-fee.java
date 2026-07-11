class Solution {
    public int helper(int prices[],int fee,int i,int buy,int dp[][]){
        if(i==prices.length)return 0;
        if(dp[i][buy]!=-1)return dp[i][buy];
        if(buy==1){
            return dp[i][buy]=Math.max(-prices[i]+helper(prices,fee,i+1,0,dp),helper(prices,fee,i+1,1,dp));
        }else{
            return dp[i][buy]=Math.max(prices[i]-fee+helper(prices,fee,i+1,1,dp),helper(prices,fee,i+1,0,dp));
        }
    }
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length][2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(prices,fee,0,1,dp);
    }
}