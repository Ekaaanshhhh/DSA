class Solution {
    public int nthRoot(int n, int m) {
        // code here
        if(n<=0)return n;
        int low = 0;
        int high = m;
        int ans=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if((int)Math.pow(mid,n)==m){
                ans=mid;
                break;
            }
            if((int)Math.pow(mid,n)<m){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}