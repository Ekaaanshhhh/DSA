class Solution {
    public int helper(int i,int count,int buy,int prices[],int dp[][][]){
        if(i==prices.length)return 0;
        if(dp[i][buy][count]!=-1)return dp[i][buy][count];
        if(buy==1 && count>0){
            return dp[i][buy][count]=Math.max(-prices[i]+helper(i+1,count-1,0,prices,dp),helper(i+1,count,1,prices,dp));
        }else if(buy==0){
            return dp[i][buy][count]=Math.max(prices[i]+helper(i+1,count,1,prices,dp),helper(i+1,count,0,prices,dp));
        }else{
            return dp[i][buy][count]=0;
        }
    }
    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length][2][k+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(0,k,1,prices,dp);
    }
}