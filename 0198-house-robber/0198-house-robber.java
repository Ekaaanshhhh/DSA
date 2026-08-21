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
        if(nums.length==1)return nums[0];
        if(nums.length==0)return 0;
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        // return helper(nums,nums.length-1,dp);

        // dp[0] = nums[0];
        // dp[1]=Math.max(nums[0],nums[1]);

        // for(int i=2;i<dp.length;i++){
        //     int pick = nums[i]+dp[i-2];
        //     int not_pick = dp[i-1];
        //     dp[i]=Math.max(pick,not_pick);
        // }
        // return dp[nums.length-1];


        int prev = nums[0];
        int curr = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            int pick = nums[i]+prev;
            int not_pick =curr;
            int next = Math.max(pick,not_pick);

            prev = curr;
            curr = next;
        }

        return curr;
    }
}