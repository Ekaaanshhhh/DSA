class Solution {
    public int aggressiveCows(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int low=1;
        int high = arr[arr.length-1]-arr[0];
        int ans=-1;
        while(low<=high){
            int mid= (low+high)/2;
            int cows_placed = helper(arr,mid);
            if(cows_placed>=k){
                ans = mid;
                low=mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
    
    public int helper(int arr[],int k){
        int cows = 1;
        int start = arr[0];
        for(int i=1;i<arr.length;i++){
            int curr= arr[i];
            if(curr-start>=k){
                cows++;
                start = curr;
            }
        }
        return cows;
    }
}