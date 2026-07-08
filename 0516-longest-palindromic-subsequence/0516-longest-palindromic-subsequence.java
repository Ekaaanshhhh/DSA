class Solution {
    // public int helper(String s,String t,int i,int j,int dp[][]){
    //     if(i<0 || j<0){
    //         return 0;
    //     }
    //     if(dp[i][j]!=-1)return dp[i][j];
    //     if(s.charAt(i)==t.charAt(j)){
    //         return dp[i][j]=1+helper(s,t,i-1,j-1,dp);
    //     }
    //     return dp[i][j]=Math.max(helper(s,t,i-1,j,dp),helper(s,t,i,j-1,dp));
    // }
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String t = sb.reverse().toString();
        int dp[][] = new int[s.length()+1][t.length()+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        // return helper(s,t,s.length()-1,t.length()-1,dp);

        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else if(dp[i-1][j]>dp[i][j-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
        
    }
}