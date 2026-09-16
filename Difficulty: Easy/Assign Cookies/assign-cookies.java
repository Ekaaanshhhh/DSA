class Solution {
    public int maxChildren(int[] greed, int[] cookie) {
        // code here
        Arrays.sort(greed);
        Arrays.sort(cookie);
        int i=0;
        int j=0;
        int cnt=0;
        while(i<greed.length && j<cookie.length){
            if(greed[i]<=cookie[j]){
                cnt++;
                i++;
                j++;
            }else if(greed[i]>cookie[j]){
                j++;
            }
        }
        return cnt;
    }
}