class Solution {
    int smallestDivisor(int[] arr, int k) {
        // Code here
        Arrays.sort(arr);
        int low = 1;
        int high = arr[arr.length-1];
        int ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(count(arr,mid)<=k){
                ans = mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int count(int arr[],int k){
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            double div = (double)(arr[i])/(double)(k);
            div = Math.ceil(div);
            cnt+=(int)div;
        }   
        return cnt;
    }
}