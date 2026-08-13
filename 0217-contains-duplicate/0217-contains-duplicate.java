class Solution {
    public boolean containsDuplicate(int[] nums) {
        int count;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(set.contains(nums[i])==false)
            {
                set.add(nums[i]);
            }
        }
        if(set.size()==nums.length)
        return false;
        else
        return true;
    }
}