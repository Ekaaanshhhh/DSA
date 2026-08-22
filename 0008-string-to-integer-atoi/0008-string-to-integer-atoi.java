class Solution {
    public int myAtoi(String s) {
        String str = s.trim();
        if(str.length()==0)return 0;
        boolean isneg=false;
        int index=0;
        if(str.charAt(0)=='-'){
            isneg = true;
            index = 1;
        }
        else if(str.charAt(0)=='+'){
            index=1;
        }
        StringBuilder sb = new StringBuilder();
        while(index<str.length() && str.charAt(index)>='0'&&str.charAt(index)<='9'){
            sb.append(str.charAt(index));
            index++;
        }
        long num = 0;
        int idx=0;
        while(idx<sb.length() && sb.charAt(idx)=='0'){
            idx++;
        }
        if(sb.length()-idx>10){
            if(isneg)return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        while(idx<sb.length() && sb.charAt(idx)>='0' && sb.charAt(idx)<='9'){
            num = num*10+(sb.charAt(idx)-'0');
            idx++;
        }

        if(isneg){
            num = num*(-1);
            if(num<(long)Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else{
                return (int)num;
            }
        }
        else{
            if(num>(long)Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            else{
                return (int)num;
            }
        }
    }
}