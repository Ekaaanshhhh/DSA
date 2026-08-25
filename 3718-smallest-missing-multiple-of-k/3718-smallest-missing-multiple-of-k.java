class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int index=1;
        for(int i=0;i<nums.length;i++){
            if(k*index == nums[i]){
                index++;
            }
        }
        return k*index;
    }
}