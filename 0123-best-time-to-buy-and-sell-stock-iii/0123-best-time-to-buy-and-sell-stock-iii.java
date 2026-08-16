class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length+1][3][2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(prices,2,0,0,dp);
    }
    public int helper(int arr[],int k,int i,int buy,int dp[][][]){
        if(i==arr.length){
            return 0;
        }
        if(k==0)return 0;
        if(dp[i][k][buy]!=-1)return dp[i][k][buy];
        if(buy==1){
            return dp[i][k][buy]=Math.max(arr[i]+helper(arr,k-1,i+1,0,dp),helper(arr,k,i+1,buy,dp));
        }else{
            return dp[i][k][buy]=Math.max(-arr[i]+helper(arr,k,i+1,1,dp),helper(arr,k,i+1,buy,dp));
        }
    }
}