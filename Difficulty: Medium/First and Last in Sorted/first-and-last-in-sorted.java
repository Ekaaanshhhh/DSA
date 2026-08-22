class Solution {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        int ans[] = {-1,-1};
        int low=0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]<x){
                low=mid+1;
            }else{
                if(arr[mid]==x)ans[0]=mid;
                high = mid-1;
            }
        }
        
        low = 0;
        high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>x){
                high=mid-1;
            }
            else{
                if(arr[mid]==x)ans[1]=mid;
                low=mid+1;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(ans[0]);
        list.add(ans[1]);
        return list;
    }
}
