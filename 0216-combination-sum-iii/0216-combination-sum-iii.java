class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int index = arr.length-1;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(arr,k,index,n,list,ans);
        return ans;
    }
    public void helper(int arr[],int k,int index,int n,List<Integer> list,List<List<Integer>> ans){
        if(n==0){
            if(k==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(index<0){
            return;
        }
        list.add(arr[index]);
        helper(arr,k-1,index-1,n-arr[index],list,ans);
        list.remove(list.size()-1);
        helper(arr,k,index-1,n,list,ans);
    }
}