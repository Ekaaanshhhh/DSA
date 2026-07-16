class Solution {
    public void helper(int i,int n,List<List<Integer>> ans,List<Integer> list,int k){
        if(i==n+1){
            if(list.size()==k){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(i);
        helper(i+1,n,ans,list,k);
        list.remove(list.size()-1);
        helper(i+1,n,ans,list,k);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(1,n,ans,list,k);
        return ans;
    }
}