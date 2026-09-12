class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int largest = arr[arr.length-1];
        ans.add(largest);
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>=largest){
                ans.add(arr[i]);
                largest = arr[i];
            }
        }
        
        Collections.reverse(ans);
        return ans;
    }
}
