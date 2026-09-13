class Solution {
    public int splitArray(int[] nums, int k) {
        if(k>nums.length)return -1;
        long low = 0;
        long high = 0;
        for(int i=0;i<nums.length;i++){
            low = Math.max(low,nums[i]);
            high+=nums[i];
        }
        long ans = -1;
        while(low<=high){
            long mid = (low+high)/2;
            int arrays_made = helper(nums,mid);
            if(arrays_made>k){
                low=mid+1;
            }else{
                ans = mid;
                high=mid-1;
            }
        }
        return (int)ans;
    }
    public int helper(int arr[],long k){
        int cnt=1;
        long sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]+sum>k){
                cnt++;
                sum=arr[i];
            }else{
                sum=sum+arr[i];
            }
        }
        return cnt;
    }
}