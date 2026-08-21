class Solution {
    public int helper(int arr[],int i,int dp[]){
        if(i==0)return arr[i];
        if(i==1)return Math.max(arr[i],arr[i-1]);
        if(dp[i]!=-1)return dp[i];

        int pick = 0;
        if(i>1){
            pick = arr[i]+helper(arr,i-2,dp);
        }
        int not_pick = helper(arr,i-1,dp);

        return dp[i]=Math.max(pick,not_pick);
    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,nums.length-1,dp);
    }
}