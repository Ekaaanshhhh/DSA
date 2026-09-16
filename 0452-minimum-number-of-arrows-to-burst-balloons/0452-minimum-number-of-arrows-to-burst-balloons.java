class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,Comparator.comparingDouble(o->o[1]));
        int count=1;
        int start = points[0][0];
        int end = points[0][1];
        int i=1;
        int total = 0;
        while(i<points.length){
            if(points[i][0]<=end){
                i++;
                continue;
            }else{
                total++;
                end = points[i][1];
                i++;
            }
        }
        total++;
        return total;
    }
}