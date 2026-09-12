class Solution {
    public boolean search(int[] arr, int key) {
        // code here
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==key)return true;
            if(arr[mid]==arr[low]&&arr[mid]==arr[high]){
                low++;
                high--;
                continue;
            }
            if(arr[low]<=arr[mid]){
                if(arr[low]<=key && arr[mid]>=key){
                    high = mid-1;
                }else{
                    low=mid+1;
                }
            }else if(arr[high]>=arr[mid]){
                if(arr[high]>=key && key>=arr[mid]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return false;
    }
}
