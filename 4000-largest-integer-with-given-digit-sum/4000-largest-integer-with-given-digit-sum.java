class Solution {
    public int largestInteger(int n, int s) {
        if(s>(n*9))return -1;
        StringBuilder sb = new StringBuilder("");
        while(n>0 && s>0){
            if(s<=9){
                sb.append(s);
                s=0;
            }
            else {
                sb.append(9);
                s=s-9;
            }
            n--;
        }
        while(n>0){
            sb.append(0);
            n--;
        }
        if(sb.length()==0)return 0;
        return Integer.parseInt(sb.toString());
    }
}