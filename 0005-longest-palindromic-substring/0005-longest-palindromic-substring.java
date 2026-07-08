class Solution {
    public String longestPalindrome(String s) {
        int maxsofar=0;
        int n=s.length();
        int leftindex=0;int rightindex=0;
        for(int center=0;center<2*n-1;center++)
        {
            int lp=center/2;
            int rp=lp+(center%2);
            while(lp>=0 && rp<n && s.charAt(lp)==s.charAt(rp))
            {
                lp--;
                rp++;
            }
            String str=s.substring(lp+1,rp);
            if(str.length()>maxsofar)
            {
                maxsofar=str.length();
                leftindex=lp+1;
                rightindex=rp;
            }
        }
        return (s.substring(leftindex,rightindex));
    }
}