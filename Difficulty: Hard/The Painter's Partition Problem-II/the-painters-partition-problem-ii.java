class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        if(k>arr.length)return -1;
        long low=0;
        long high = 0;
        for(int x:arr){
            low = Math.max(low,x);
            high+=x;
        }
        long ans = -1;
        while(low<=high){
            long mid = (low+high)/2;
            int painter_needed = helper(arr,mid);
            if(painter_needed>k){
                low=mid+1;
            }else{
                ans=mid;
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
