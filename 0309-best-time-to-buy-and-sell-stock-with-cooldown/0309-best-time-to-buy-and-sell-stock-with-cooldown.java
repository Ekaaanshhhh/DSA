class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length+1][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(prices,0,0,dp);
    }
    public int helper(int arr[],int i,int buy,int dp[][]){
        if(i>=arr.length)return 0;
        if(dp[i][buy]!=-1)return dp[i][buy];
        if(buy==1){
            return dp[i][buy]=Math.max(arr[i]+helper(arr,i+2,0,dp),helper(arr,i+1,buy,dp));
        }
        else{
            return dp[i][buy]=Math.max(-arr[i]+helper(arr,i+1,1,dp),helper(arr,i+1,buy,dp));
        }
    }
}