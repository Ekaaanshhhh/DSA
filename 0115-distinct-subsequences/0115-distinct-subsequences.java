class Solution {
    public int helper(String s,String t,int i,int j,int dp[][]){
        if(i<0){
            if(j<0)return 1;
            else return 0;
        }
        if(j<0)return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=helper(s,t,i-1,j-1,dp)+helper(s,t,i-1,j,dp);
        }
        else{
            return dp[i][j]=helper(s,t,i-1,j,dp);
        }
    }
    public int numDistinct(String s, String t) {
        // int dp[][] = new int[s.length()][t.length()];
        // for(int i=0;i<dp.length;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return helper(s,t,s.length()-1,t.length()-1,dp);

        int dp[][] = new int[s.length()+1][t.length()+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        dp[0][0]=1;
        for(int j=1;j<dp[0].length;j++){
            dp[0][j]=0;
        }
        for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}