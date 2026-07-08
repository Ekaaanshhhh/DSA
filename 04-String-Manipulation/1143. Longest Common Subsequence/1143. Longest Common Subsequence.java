1class Solution {
2    public int helper(int i,int j,String s1,String s2,int dp[][]){
3        if(i<0 || j<0){
4            return 0;
5        }
6        if(dp[i][j]!=-1)return dp[i][j];
7        int ans_matching = 0;
8        int ans_notmatching = 0;
9        if(s1.charAt(i)==s2.charAt(j)){
10            ans_matching = 1+helper(i-1,j-1,s1,s2,dp);
11        }else{
12            ans_notmatching = Math.max(helper(i-1,j,s1,s2,dp),helper(i,j-1,s1,s2,dp));
13        }
14
15        return dp[i][j]=ans_matching+ans_notmatching;
16        
17    }
18    public int longestCommonSubsequence(String text1, String text2) {
19        int dp[][] = new int[text1.length()][text2.length()];
20        for(int i=0;i<dp.length;i++){
21            Arrays.fill(dp[i],-1);
22        }
23        return helper(text1.length()-1,text2.length()-1,text1,text2,dp);
24    }
25}