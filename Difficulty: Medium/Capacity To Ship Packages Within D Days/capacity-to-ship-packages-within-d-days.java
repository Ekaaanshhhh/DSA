class Solution {
    public int leastWeightCapacity(ArrayList<Integer> arr, int d) {
        // code here
        int low = Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<arr.size();i++){
            high = high+arr.get(i);
            low = Math.max(low,arr.get(i));
        }
        int ans=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(daystaken(arr,mid)<=d){
                ans = mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int daystaken(ArrayList<Integer> arr,int k){
        int cnt=1;
        int sum=0;
        for(int i=0;i<arr.size();i++){
            if(sum+arr.get(i)<=k){
                sum=sum+arr.get(i);
                continue;
            }else{
                cnt++;
                sum=arr.get(i);
            }
        }
        return cnt;
    }
}