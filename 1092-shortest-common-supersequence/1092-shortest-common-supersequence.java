class Solution {
    public void fill(String str1,String str2,int m,int n,int dp[][]){
        for(int i=0;i<m;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<n;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        fill(str1,str2,str1.length()+1,str2.length()+1,dp);

        int i=str1.length();
        int j = str2.length();
        String lcs = "";
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                lcs = str1.charAt(i-1)+lcs;
                i=i-1;
                j=j-1;
            }else if(dp[i-1][j]>dp[i][j-1]){
                lcs = str1.charAt(i-1)+lcs;
                i=i-1;
            }else{
                lcs = str2.charAt(j-1)+lcs;
                j=j-1;
            }
        }
        while(i>0){
            lcs = str1.charAt(i-1)+lcs;
            i--;
        }
        while(j>0){
            lcs = str2.charAt(j-1)+lcs;
            j--;
        }

        return lcs;
    }
}