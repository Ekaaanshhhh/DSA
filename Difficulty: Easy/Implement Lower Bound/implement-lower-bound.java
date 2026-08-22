class Solution {
    int lowerBound(int[] arr, int target) {
        // code here
        if(target>=arr[arr.length-1])return arr.length;
        int ans=-1;
        int low=0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
