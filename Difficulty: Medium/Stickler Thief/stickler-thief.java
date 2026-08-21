class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int dp[] = new int[arr.length+1];
        Arrays.fill(dp,-1);
        return helper(arr,arr.length-1,dp);
    }
    public int helper(int arr[],int i,int dp[]){
        if(i<0)return 0;
        if(dp[i+1]!=-1)return dp[i+1];
        int pick = arr[i]+helper(arr,i-2,dp);
        int not_pick = helper(arr,i-1,dp);
        
        return dp[i+1]=Math.max(pick,not_pick);
    }
}