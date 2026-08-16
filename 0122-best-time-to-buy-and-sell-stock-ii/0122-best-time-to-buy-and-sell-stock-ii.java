class Solution {
    public int maxProfit(int[] prices) {
        
        int dp[][] = new int[prices.length+1][2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        // return helper(prices,0,0,dp);

        for(int i=0;i<dp[0].length;i++){
            dp[prices.length][i]=0;
        }

        for(int index=dp.length-2;index>=0;index--){
            for(int buy=1;buy>=0;buy--){
                if(buy==1){
                    dp[index][buy]=Math.max(prices[index]+dp[index+1][0],dp[index+1][buy]);
                }
                 else{
                    dp[index][buy]=Math.max(-prices[index]+dp[index+1][1],dp[index+1][buy]);
                 }
            }
        }
        return dp[0][0];
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