class Solution {
    public int longestConsecutive(int[] nums) {
    if(nums.length==0)return 0;
      Arrays.sort(nums);
      int maxlen=1;
      int currlen=1;
      int lp=0;
      int rp=1;
      while(rp<nums.length && lp<nums.length)
      {
        if(nums[rp]-nums[lp]==1)
        {
            currlen++;
            lp++;
            rp++;
        }
        else if(nums[lp]==nums[rp])
        {
            lp++;
            rp++;
        }
        else{
            maxlen=Math.max(currlen,maxlen);
            currlen=1;
            lp=rp;
            rp=lp+1;
        }
        maxlen=Math.max(currlen,maxlen);
      }
    return maxlen;  
    // HashSet<Integer> set = new HashSet<>();
    // int maxlength=0;
    // for(int i=0;i<nums.length;i++){
    //     set.add(nums[i]);
    // }

    // int index=0;
    // while(index<nums.length){
    //     int count=1;
    //     int element = nums[index]+1;
    //     while(set.contains(element)){
    //         count++;
    //         element++;
    //     }
    //     maxlength = Math.max(count,maxlength);
    //     index++; 
    // }

    // return maxlength;
    }
}