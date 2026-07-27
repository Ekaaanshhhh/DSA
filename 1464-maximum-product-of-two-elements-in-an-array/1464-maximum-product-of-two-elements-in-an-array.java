class Solution {
    public int maxProduct(int[] nums) {
       int largest = nums[0];
       int li = 0;
       for(int i=1;i<nums.length;i++){
            if(largest<nums[i]){
                largest = nums[i];
                li=i;
            }
       }
       int sl = -1;
       for(int i=0;i<nums.length;i++){
            if(sl<nums[i] && i!=li){
                sl=nums[i];
            }
       }
       return (sl-1)*(largest-1);
    }
}