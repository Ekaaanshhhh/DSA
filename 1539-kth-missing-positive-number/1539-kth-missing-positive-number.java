class Solution {
    public int findKthPositive(int[] arr, int k) {
        // HashSet<Integer> set = new HashSet<>();
        // for(int i=0;i<arr.length;i++){
        //     set.add(arr[i]);
        // }
        // int missing=-1;
        // int index=1;
        // while(k>0){
        //     if(!set.contains(index)){
        //         k--;
        //         missing=index;
        //     }
        //     index++;
        // }
        // return missing;


        for(int i=0;i<arr.length;i++){
            if(arr[i]<=k)k++;
            else break;
        }
        return k;
        
    }
}