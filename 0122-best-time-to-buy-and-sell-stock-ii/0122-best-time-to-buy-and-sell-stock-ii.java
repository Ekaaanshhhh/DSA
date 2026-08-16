class Solution {
    public int maxProfit(int[] prices) {
        
        int dp[][] = new int[prices.length+1][2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(prices,0,0,dp);
    }
    public int helper(int prices[],int index,int buy,int dp[][]){
        if(index==prices.length){
            return 0;
        }
        if(dp[index][buy]!=-1)return dp[index][buy];
        if(buy==1){
            return dp[index][buy]=Math.max(prices[index]+helper(prices,index+1,0,dp),helper(prices,index+1,buy,dp));
        }
        else{
        return dp[index][buy]=Math.max(-prices[index]+helper(prices,index+1,1,dp),helper(prices,index+1,buy,dp));
        }
    }
}