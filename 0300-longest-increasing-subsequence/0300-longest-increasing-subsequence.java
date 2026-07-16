class Solution {
    public int helper(int nums[],int i,int prev,int dp[][]){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev+1]!=-1)return dp[i][prev+1];
        int take=0;
        if(prev==-1 || nums[prev]<nums[i]){
            take = 1+helper(nums,i+1,i,dp);
        }
        int not_take= helper(nums,i+1,prev,dp);

        return dp[i][prev+1]=Math.max(take,not_take);
    }
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(nums,0,-1,dp);
    }
}