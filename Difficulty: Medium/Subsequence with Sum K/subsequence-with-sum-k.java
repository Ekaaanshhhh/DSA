class Solution {
    public boolean checkSubsequenceSum(int[] arr, int k) {
        // code here
        int dp[][] = new int[k+1][arr.length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(arr,k,arr.length-1,dp);
    }
    public boolean helper(int arr[],int k,int i,int dp[][]){
        if(k==0)return true;
        if(i==0){
            if(arr[0]==k)return true;
            return false;
        }
        if(k<0)return false;
        if(dp[k][i]!=-1)return dp[k][i]==0?false:true;
        
        boolean pick = helper(arr,k-arr[i],i-1,dp);
        boolean not_pick = helper(arr,k,i-1,dp);
        
        dp[k][i] = pick||not_pick?1:0;
        
        return dp[k][i]==1?true:false;
    }
}