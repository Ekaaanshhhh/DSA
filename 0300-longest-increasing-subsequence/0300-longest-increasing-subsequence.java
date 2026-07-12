class Solution {
    public int helper(int nums[],int i,int prev,int dp[][]){
        if(i==nums.length+1){
            return 0;
        }
        if(dp[i][prev]!=-1)return dp[i][prev];
        int not_take = helper(nums,i+1,prev,dp);
        int take = 0;
        if(prev==0 || nums[i-1]>nums[prev-1]){
            take = 1+helper(nums,i+1,i,dp);
        }
        return dp[i][prev]=Math.max(take,not_take);
    }
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length+1][nums.length+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(nums,1,0,dp);
    }
}