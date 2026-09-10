class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arr[]=new int[nums.length];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=0;
        }
        int countzeros=0;
        int product=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                countzeros++;
            }
            else{
                product=product*nums[i];
            }
        }
        if(countzeros>1)
        {
            return arr;
        }
        else if(countzeros==1)
        {
            for(int i=0;i<arr.length;i++)
            {
                if(nums[i]==0)
                {
                    arr[i]=product;
                }
            }
            return arr;
        }
        else{
            for(int i=0;i<arr.length;i++)
            {
                arr[i]=product/nums[i];
            }
            return arr;
        }
        }
    }