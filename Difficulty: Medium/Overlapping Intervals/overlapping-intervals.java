class Solution {
    public ArrayList<ArrayList<Integer>> mergeOverlap(int[][] arr) {
        // Code here
        Arrays.sort(arr,Comparator.comparingDouble(o->o[0]));
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int start = arr[0][0];
        int end = arr[0][1];
        
        for(int i=1;i<arr.length;i++){
            int curr_start = arr[i][0];
            int curr_end = arr[i][1];
            
            if(curr_start<=end){
                start = Math.min(start,curr_start);
                end = Math.max(end,curr_end);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(end);
                ans.add(list);
                
                start = curr_start;
                end = curr_end;
            }
            
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        ans.add(list);
        
        return ans;
    }
}