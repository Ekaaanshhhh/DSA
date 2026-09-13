class Solution {
    public String maxOdd(String s) {
        // code here
        int max_ind = -1; 
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='1'|| ch=='3'|| ch=='5'|| ch=='7'|| ch=='9'){
                max_ind = i;
            }
        }
        if(max_ind==-1)return "";
        return s.substring(0,max_ind+1);
    }
}