class Solution {
    static boolean canAttend(int[][] arr) {
        // code here
        Arrays.sort(arr,Comparator.comparingDouble(o->o[0]));
        int start = arr[0][0];
        int end = arr[0][1];
        for(int i=1;i<arr.length;i++){
            int curr_start = arr[i][0];
            if(curr_start<end)return false;
            
            start = curr_start;
            end = arr[i][1];
        }
        return true;
    }
}