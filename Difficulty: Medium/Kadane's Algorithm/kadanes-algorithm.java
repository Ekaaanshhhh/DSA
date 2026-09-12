class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        int max_so_far = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum = sum+arr[i];
            max_so_far = Math.max(max_so_far,sum);
            if(sum<0){
                sum=0;
            }
        }
        return max_so_far;
    }
}
