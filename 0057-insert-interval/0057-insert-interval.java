class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals,Comparator.comparingDouble(o->o[0]));
        List<int[]> list = new ArrayList<>();
        boolean added = false;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]>=newInterval[0] && !added){
                added = true;
                list.add(newInterval);
            }
            list.add(intervals[i]);
        }
        // return list.toArray(new int[0][]);
        if(!added){
            list.add(newInterval);
        }
        List<int[]> finalans = new ArrayList<>();
        int start = list.get(0)[0];
        int end = list.get(0)[1];
        for(int i=1;i<list.size();i++){
            int curr_start = list.get(i)[0];
            int curr_end = list.get(i)[1];
            if(curr_start<=end){
                start = Math.min(start,curr_start);
                end = Math.max(end,curr_end);
            }
            else{
                int ans[] = new int[2];
                ans[0] = start;
                ans[1] = end;
                finalans.add(ans);

                start = curr_start;
                end = curr_end;
            }
        }
        int ans[] = new int[2];
        ans[0] = start;
        ans[1] = end;
        finalans.add(ans);

        return finalans.toArray(new int[0][]);
    }
}