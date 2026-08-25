class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int ans=-1;
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(mid!=0 && mid!=arr.length-1 && arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1])ans=mid;

            if((mid==0 && arr[mid]<arr[mid+1])||(arr[mid]>=arr[mid-1])){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}