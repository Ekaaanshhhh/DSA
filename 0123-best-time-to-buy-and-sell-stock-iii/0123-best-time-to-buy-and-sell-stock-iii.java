class Solution {
    public int helper(int i,int buy,int count,int prices[],int dp[][][]){
        if(i==prices.length){
            return 0;
        }
        if(dp[i][buy][count]!=-1)return dp[i][buy][count];
        if(buy==1 && count>0){
            return dp[i][buy][count]=Math.max(-prices[i]+helper(i+1,0,count-1,prices,dp),helper(i+1,1,count,prices,dp));
        }
        else if(buy==0){
            return dp[i][buy][count]=Math.max(prices[i]+helper(i+1,1,count,prices,dp),helper(i+1,0,count,prices,dp));
        }else{
            return dp[i][buy][count]=0;
        }
    }
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][2][3];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(0,1,2,prices,dp);

        // int n = prices.length;
        // int dp[][][] = new int[n+1][2][3];
        // for(int i=n-1;i>=0;i--){
        //     for(int j=0;j<2;j++){
        //         for(int k=0;k<3;k++){
        //             if(j==1 && k>0){

        //             }
        //         }
        //     }
        // }
    }
}