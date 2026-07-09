class Solution {
    public int helper(String s,String t,int i,int j,int dp[][]){
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=1+helper(s,t,i-1,j-1,dp);
        }

        return dp[i][j]=Math.max(helper(s,t,i-1,j,dp),helper(s,t,i,j-1,dp));
    }
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int lcs = helper(word1,word2,word1.length()-1,word2.length()-1,dp);
        return word1.length()-lcs+word2.length()-lcs;
    }
}