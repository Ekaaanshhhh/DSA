class Solution {
    public int calculateDays(int arr[],int k){
        int day=1;
        int load=0;
        for(int i=0;i<arr.length;i++){
            if(load+arr[i]>k){
                day=day+1;
                load=arr[i];
            }else{
                load+=arr[i];
            }
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        int max=weights[0];
        int sum=0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
            max=Math.max(weights[i],max);
        }
        int low = max;
        int high = sum;
        int ans=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(calculateDays(weights,mid)>days){
                low=mid+1;
            }else{
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
}