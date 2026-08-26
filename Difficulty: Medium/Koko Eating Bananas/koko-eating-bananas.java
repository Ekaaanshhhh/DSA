class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int ans=-1;
        int low = 1;
        int high = arr[arr.length-1];
        while(low<=high){
            int mid = (low+high)/2;
            if(canEat(arr,mid)<=k){
                ans = mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int canEat(int arr[],int k){
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=k)cnt++;
            else cnt = cnt+(arr[i]/k + (arr[i]%k==0?0:1));
        }
        return cnt;
    }
}
