class Solution {
    public boolean check(int n,int t){
        int p = 1;
        while(n>0){
            p=p*(n%10);
            n/=10;
        }
        return p%t==0;
    }
    public int smallestNumber(int n, int t) {
        while(check(n,t)==false){
            n++;
        }
        return n;
    }
}